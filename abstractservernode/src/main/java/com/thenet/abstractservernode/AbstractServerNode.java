package com.thenet.abstractservernode;


import com.hazelcast.config.Config;
import com.hazelcast.config.MemberAttributeConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.MembershipListener;
import com.thenet.abstractservernode.member.MemberAttributeType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class AbstractServerNode {

    private static final Logger LOGGER = Logger.getLogger(AbstractServerNode.class.getClass().getName());

    private HazelcastInstance instance;

    public enum NODETYPE {
        GATEWAY, DISCOVERY, DATA
    }

    public AbstractServerNode(final NODETYPE nodeType, final String name, final Integer version,
                              final List<String> topics) {
        Config cfg = new Config();
        cfg.setMemberAttributeConfig(createMemberAttributeConfig(nodeType, name, version, topics));
        instance = Hazelcast.newHazelcastInstance(cfg);
    }


    public void addMembershipListener(MembershipListener membershipListener) {
        instance.getCluster().addMembershipListener(membershipListener);
    }


    private MemberAttributeConfig createMemberAttributeConfig(final NODETYPE nodeType,
                                                              final String name, final Integer version,
                                                              final List<String> topics) {

        Map<String, Object> nodeAttributes = new HashMap<>();
        nodeAttributes.put(MemberAttributeType.NODE_TYPE.name(), nodeType);
        nodeAttributes.put(MemberAttributeType.NODE_NAME.name(), name);
        nodeAttributes.put(MemberAttributeType.NODE_VERSION.name(), version);
        nodeAttributes.put(MemberAttributeType.NODE_TOPICS.name(), topics);

        MemberAttributeConfig memberAttributeConfig = new MemberAttributeConfig();
        memberAttributeConfig.setAttributes(nodeAttributes);

        return memberAttributeConfig;
    }
}
