package com.example.pojo;

/**
 * singleton instance where
 *  hostname=ip
 *  port=destination port
 *  id=application id
 *
 *  is stored
 *
 */
public class ConnectionProperties {

    private String hostname;
    private String id;
    private int port;
    private static ConnectionProperties connectionProperties;


    /**
     * returnin only one instance of ConnectionPropeties
     * @return ConnectionProperties
     */
    public static ConnectionProperties getInstance(){
        if(connectionProperties==null)
            connectionProperties=new ConnectionProperties();

        return connectionProperties;
    }


    /**
     * defualt constructor private to assure than we cant make more than one instance of this class
     */
    private ConnectionProperties(){
    }


    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
