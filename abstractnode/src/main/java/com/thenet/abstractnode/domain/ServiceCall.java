package com.thenet.abstractnode.domain;

public class ServiceCall {

    enum RequestType {
        GET, POST, PUT, DELETE
    }

    private final RequestType requestType;
    private Request request;
    private Response response;

    public ServiceCall(RequestType requestType, Request request) {
        this.requestType = requestType;
        this.request = request;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public RequestType getRequestType() {
        return requestType;
    }

    public Request getRequest() {
        return request;
    }

    public Response getResponse() {
        return response;
    }
}
