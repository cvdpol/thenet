package com.thenet.datanode;

import com.thenet.abstractnode.domain.Call;
import com.thenet.abstractservernode.AbstractServerNode;

import java.util.List;
import java.util.Map;

public class DataNode extends AbstractServerNode {

    protected Map<String, Call> serviceCallMap;

    public DataNode(final String name, final Integer version, final List<String>topics) {
        super(NODETYPE.DATA, name, version, topics);
        //serviceCallMap = getInstance().getMap("serviceCallMap");
    }


}
