package com.thenet.discoverynode;

import com.thenet.abstractservernode.member.MemberInformation;
import com.thenet.abstractservernode.AbstractServerNode;
import com.thenet.discoverynode.listener.ClusterMembershipListener;

import java.util.Arrays;

public class DiscoveryNode extends AbstractServerNode {


    final static String TOPIC_DISCOVERY = "THE_NET_TOPIC_DISCOVERY";

    public DiscoveryNode(final String name, final Integer version) {
        super(NODETYPE.DISCOVERY, name, version, Arrays.asList(TOPIC_DISCOVERY));

        addMembershipListener(new ClusterMembershipListener(this));
    }

    public void memberAdd(MemberInformation memberInformation){};
    public void memberRemoved(MemberInformation memberInformation){};

}
