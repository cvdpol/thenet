package com.thenet.discoverynode.listener;

import com.thenet.abstractservernode.member.MemberInformation;

public interface MemberListener {

    void memberAdd(MemberInformation memberInformation);
    void memberRemoved(MemberInformation memberInformation);
}
