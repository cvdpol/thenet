package com.thenet.abstractservernode;


import com.hazelcast.config.Config;
import com.hazelcast.config.MemberAttributeConfig;
import com.hazelcast.core.*;
import com.thenet.abstractnode.AbstractNode;
import com.thenet.abstractnode.domain.Call;
import com.thenet.abstractservernode.member.MemberAttributeType;

import java.util.*;
import java.util.logging.Logger;

public class AbstractServerNode extends AbstractNode {

    private static final Logger LOGGER = Logger.getLogger(AbstractServerNode.class.getClass().getName());

    final static String RESPONSE_TOPIC = UUID.randomUUID().toString();

    private HazelcastInstance instance;

    public enum NODETYPE {
        SERVICE, DISCOVERY, DATA, GATEWAY
    }

    public AbstractServerNode(final NODETYPE nodeType, final String name, final Integer version,
                              final List<String> topics) {
        Config cfg = new Config();
        cfg.setMemberAttributeConfig(createMemberAttributeConfig(nodeType, name, version, topics));
        instance = Hazelcast.newHazelcastInstance(cfg);

        // Create topic for responses
        createTopic(RESPONSE_TOPIC);

        if (topics!=null) {
            createTopics(topics);
        }
    }

    private void createTopics(List<String> topics) {
        topics.forEach((topic) -> {
            createTopic(topic);
        });
    }

    private void createTopic(String topic) {
        ITopic<Call> topicInstance = getInstance().getReliableTopic(topic);
        topicInstance.addMessageListener(new MessageListenerImpl(this));
    }

    public String getSource() {
        return RESPONSE_TOPIC;
    }

    public void addMembershipListener(MembershipListener membershipListener) {
        instance.getCluster().addMembershipListener(membershipListener);
    }

    protected HazelcastInstance getInstance() {
        return instance;
    }

    protected List<?> send(Call call) {
        ITopic<Call> topicInstance = getInstance().getReliableTopic(call.getTopic());
        topicInstance.publish(call);


        return new ArrayList<>();
    }


    protected void onMessage(Message<Call> call){};

    private static class MessageListenerImpl implements MessageListener<Call> {

        private AbstractServerNode abstractServerNode;

        public MessageListenerImpl(AbstractServerNode abstractServerNode) {
            this.abstractServerNode = abstractServerNode;
        }

        public void onMessage(Message<Call> call) {
            abstractServerNode.onMessage(call);
        }
    }



    private MemberAttributeConfig createMemberAttributeConfig(final NODETYPE nodeType,
                                                              final String name, final Integer version,
                                                              final List<String> topics) {

        Map<String, Object> nodeAttributes = new HashMap<>();
        nodeAttributes.put(MemberAttributeType.NODE_TYPE.name(), nodeType);
        nodeAttributes.put(MemberAttributeType.NODE_NAME.name(), name);
        nodeAttributes.put(MemberAttributeType.NODE_VERSION.name(), version);

        if (topics!=null) {
            nodeAttributes.put(MemberAttributeType.NODE_TOPICS.name(), topics);
        }

        MemberAttributeConfig memberAttributeConfig = new MemberAttributeConfig();
        memberAttributeConfig.setAttributes(nodeAttributes);

        return memberAttributeConfig;
    }


    protected void sendResponse(Message<Call> call) {
        ITopic<Call> topicInstance = getInstance().getReliableTopic(call.getMessageObject().getSource());
        topicInstance.publish(call.getMessageObject());
    }

}
