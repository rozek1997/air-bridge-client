package com.example.pojo;

/**
 * pojo used for converting from object to json
 */
public class DataToSend {

    private String broadcasterID;
    private String data;

    public String getBroadcasterID() {
        return broadcasterID;
    }

    public void setBroadcasterID(String broadcasterID) {
        this.broadcasterID = broadcasterID;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
