package com.thenet.discoverynode.listener;

import com.thenet.abstractnode.member.MemberInformation;

public interface MemberListener {

    void memberAdd(MemberInformation memberInformation);
    void memberRemoved(MemberInformation memberInformation);
}
