package com.thenet.gateway;

import com.thenet.abstractnode.domain.ServiceCall;
import com.thenet.abstractservernode.AbstractServerNode;

import java.util.Arrays;
import java.util.Map;

public class Gateway extends AbstractServerNode {

    final static String TOPIC_GATEWAY = "THE_NET_TOPIC_GATEWAY";

    protected Map<String, ServiceCall> serviceCallMap;

    public Gateway(final String name, final Integer version) {
        super(AbstractServerNode.NODETYPE.GATEWAY, name, version, Arrays.asList(TOPIC_GATEWAY));
        //serviceCallMap = getInstance().getMap("serviceCallMap");
    }


}
