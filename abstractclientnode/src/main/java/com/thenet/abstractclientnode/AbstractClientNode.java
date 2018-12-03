package com.thenet.abstractclientnode;


import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.config.GroupConfig;
import com.hazelcast.core.HazelcastInstance;
import com.thenet.abstractnode.AbstractNode;

import java.util.List;
import java.util.logging.Logger;

public class AbstractClientNode extends AbstractNode {

    private static final Logger LOGGER = Logger.getLogger(AbstractClientNode.class.getClass().getName());

    private HazelcastInstance instance;

    public enum NODETYPE {
        GATEWAY
    }

    public AbstractClientNode(final NODETYPE nodeType, final String name, final Integer version,
                              final List<String> topics) {


//        ClientConfig config = new ClientConfig();
//
//        GroupConfig groupConfig = config.getGroupConfig();
//        groupConfig.setName("dev");
//        groupConfig.setPassword("dev-pass");
//        HazelcastInstance hzClient = HazelcastClient.newHazelcastClient(config);





    }


//    public void addMembershipListener(MembershipListener membershipListener) {
//        instance.getCluster().addMembershipListener(membershipListener);
//    }


//    private MemberAttributeConfig createMemberAttributeConfig(final AbstractNode.NODETYPE nodeType,
//                                                              final String name, final Integer version,
//                                                              final List<String> topics) {
//
//        Map<String, Object> nodeAttributes = new HashMap<>();
//        nodeAttributes.put(MemberAttributeType.NODE_TYPE.name(), nodeType);
//        nodeAttributes.put(MemberAttributeType.NODE_NAME.name(), name);
//        nodeAttributes.put(MemberAttributeType.NODE_VERSION.name(), version);
//        nodeAttributes.put(MemberAttributeType.NODE_TOPICS.name(), topics);
//
//        MemberAttributeConfig memberAttributeConfig = new MemberAttributeConfig();
//        memberAttributeConfig.setAttributes(nodeAttributes);
//
//        return memberAttributeConfig;
//    }
}
