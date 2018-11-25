package com.thenet.abstractservernode.member;

import com.thenet.abstractservernode.AbstractServerNode;

import java.util.List;

public class MemberInformation {
    AbstractServerNode.NODETYPE nodetype;

    private String name;
    private Integer version;

    private List<String> subscribedTopics;

    public MemberInformation(final AbstractServerNode.NODETYPE nodetype,
                             final String name, final Integer version,
                             final List<String> subscribedTopics) {
        this.nodetype = nodetype;
        this.name = name;
        this.version = version;
        this.subscribedTopics = subscribedTopics;
    }

    public AbstractServerNode.NODETYPE getNodetype() {
        return nodetype;
    }

    public String getName() {
        return name;
    }

    public Integer getVersion() {
        return version;
    }

    public List<String> getSubscribedTopics() {
        return subscribedTopics;
    }
}
