package com.thenet.abstractservernode.member;

import com.hazelcast.config.MemberAttributeConfig;
import com.thenet.abstractservernode.AbstractServerNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberConfig {

    public static MemberAttributeConfig createMemberAttributeConfig(final AbstractServerNode.NODETYPE nodeType,
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
}
