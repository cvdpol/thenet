package com.thenet.abstractnode.member;

import com.thenet.abstractnode.AbstractNode;

import java.util.List;

public class MemberInformation {
    AbstractNode.NODETYPE nodetype;

    private String name;
    private Integer version;

    private List<String> subscribedTopics;

    public MemberInformation(final AbstractNode.NODETYPE nodetype,
                             final String name, final Integer version,
                             final List<String> subscribedTopics) {
        this.nodetype = nodetype;
        this.name = name;
        this.version = version;
        this.subscribedTopics = subscribedTopics;
    }

    public AbstractNode.NODETYPE getNodetype() {
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
