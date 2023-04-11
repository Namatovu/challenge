package com.example.demo.Utilities;

import java.time.LocalTime;
import java.time.ZoneId;

public class GenericResponse {
    private String returnMessage;
    private Object returnObject;
    private Integer returnCode;
    LocalTime localTime = LocalTime.now(ZoneId.of("UTC"));

    public GenericResponse() {
    }

    public GenericResponse(Integer returnCode, String returnMessage) {

        this.returnMessage = returnMessage;
        this.returnCode = returnCode;
    }

    public GenericResponse(Integer returnCode, String returnMessage, Object returnObject) {

        this.returnMessage = returnMessage;
        this.returnObject = returnObject;
        this.returnCode = returnCode;
    }

    public String getReturnMessage() {
        return returnMessage;
    }

    public void setReturnMessage(String returnMessage) {
        this.returnMessage = returnMessage;
    }

    public Object getReturnObject() {
        return returnObject;
    }

    public void setReturnObject(Object returnObject) {
        this.returnObject = returnObject;
    }

    public Integer getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(Integer returnCode) {
        this.returnCode = returnCode;
    }
}
