package com.thenet.datanode;

import com.thenet.abstractservernode.AbstractServerNode;
import com.thenet.abstractservernode.domain.ServiceCall;

import java.util.List;
import java.util.Map;

public class DataServerNode extends AbstractServerNode {

    protected Map<String, ServiceCall> serviceCallMap;

    public DataServerNode(final String name, final Integer version, final List<String>topics) {
        super(NODETYPE.DATA, name, version, topics);
        //serviceCallMap = getInstance().getMap("serviceCallMap");
    }


}
