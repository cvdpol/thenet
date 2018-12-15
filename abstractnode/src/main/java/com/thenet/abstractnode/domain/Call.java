package com.thenet.abstractnode.domain;

import java.io.Serializable;

public class Call implements Serializable {

    private final RequestType requestType;
    private final String topic;
    private final String source;
    private final Request request;
    private Response response;

    public enum RequestType {
        GET, POST, PUT, DELETE
    }

    public Call(final RequestType requestType, final String topic, final String source, final Request request) {
        this.requestType = requestType;
        this.topic = topic;
        this.source = source;
        this.request = request;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public RequestType getRequestType() {
        return requestType;
    }

    public String getTopic() {
        return topic;
    }

    public String getSource() {
        return source;
    }

    public Request getRequest() {
        return request;
    }

    public Response getResponse() {
        return response;
    }
}
