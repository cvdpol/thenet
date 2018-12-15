package com.thenet.gateway;

import com.thenet.abstractservernode.AbstractServerNode;

public class Gateway extends AbstractServerNode {

    public Gateway(final String name, final Integer version) {
        super(AbstractServerNode.NODETYPE.GATEWAY, name, version, null);
    }

}
