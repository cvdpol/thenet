package com.thenet.discoverynode.listener;

import com.hazelcast.core.MemberAttributeEvent;
import com.hazelcast.core.MembershipEvent;
import com.hazelcast.core.MembershipListener;
import com.thenet.abstractservernode.AbstractServerNode;
import com.thenet.abstractservernode.member.MemberInformation;
import com.thenet.abstractservernode.member.MemberAttributeType;
import com.thenet.discoverynode.DiscoveryServerNode;

import java.util.List;

public class ClusterMembershipListener  implements MembershipListener {

    private DiscoveryServerNode discoveryNode;
    public ClusterMembershipListener(final DiscoveryServerNode discoveryNode) {
        this.discoveryNode = discoveryNode;
    }

    public void memberAdded(final MembershipEvent membershipEvent) {
        discoveryNode.memberAdd(getMemberInformation(membershipEvent));
    }

    public void memberRemoved(final MembershipEvent membershipEvent) {
        discoveryNode.memberRemoved(getMemberInformation(membershipEvent));
    }

    public void memberAttributeChanged(final MemberAttributeEvent memberAttributeEvent) {
    }

    private MemberInformation getMemberInformation(final MembershipEvent membershipEvent) {
       return new MemberInformation(
                (AbstractServerNode.NODETYPE) getMemberValue(membershipEvent, MemberAttributeType.NODE_TYPE),
                (String) getMemberValue(membershipEvent, MemberAttributeType.NODE_NAME),
                (Integer) getMemberValue(membershipEvent, MemberAttributeType.NODE_VERSION),
                (List<String>) getMemberValue(membershipEvent, MemberAttributeType.NODE_TOPICS));
    }

    private Object getMemberValue(final MembershipEvent membershipEvent, final MemberAttributeType memberAttributeType) {
        return membershipEvent.getMember().getAttributes().get(memberAttributeType.name());
    }
}
