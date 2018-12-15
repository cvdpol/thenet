package com.thenet.datanode;

import com.hazelcast.core.ITopic;
import com.hazelcast.core.Message;
import com.hazelcast.core.MessageListener;
import com.thenet.abstractnode.domain.Call;
import com.thenet.abstractservernode.AbstractServerNode;

import java.util.List;
import java.util.Map;

public class ServiceNode extends AbstractServerNode {


    public ServiceNode(final String name, final Integer version, final List<String>topics) {
        super(NODETYPE.SERVICE, name, version, topics);

    }

}
