package com.thenet.datanode;

import com.thenet.abstractnode.domain.ServiceCall;
import com.thenet.abstractservernode.AbstractServerNode;

import java.util.List;
import java.util.Map;

public class ServiceNode extends AbstractServerNode {

    protected Map<String, ServiceCall> serviceCallMap;

    public ServiceNode(final String name, final Integer version, final List<String>topics) {
        super(NODETYPE.SERVICE, name, version, topics);
        //serviceCallMap = getInstance().getMap("serviceCallMap");
    }


}
