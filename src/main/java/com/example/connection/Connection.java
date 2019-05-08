package com.example.connection;

import com.example.pojo.ConnectionProperties;
import com.example.pojo.DataToSend;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;


public class Connection {


    private Socket socket;
    private PrintWriter output; //stream for sending json
    private DataToSend dataToSend; //temporary object which wil be converted to json
    private ObjectMapper jsonConverter; //object to json mapper

    public Connection(){

        this.jsonConverter=new ObjectMapper();
    }

    /**
     * Initiialize socket, streams. Prepare for sending
     * @throws IOException
     */
    public void connect() throws IOException {
        this.socket=new Socket(ConnectionProperties.getInstance().getHostname(), ConnectionProperties.getInstance().getPort());
        this.output=new PrintWriter(socket.getOutputStream(), true);
        this.dataToSend=new DataToSend();

    }


    /**
     * convert object to json and send via printwriter
     * @param input
     * @throws IOException
     * @throws JsonProcessingException
     */
    public void sendData(String input) throws IOException, JsonProcessingException{
        output.println(convertPojoToJson(input));
    }


    private String convertPojoToJson(String input) throws JsonProcessingException {
        dataToSend.setBroadcasterID(ConnectionProperties.getInstance().getId());
        dataToSend.setData(input);


        return jsonConverter.writeValueAsString(dataToSend);
    }

    /**
     * send only header in this case name of application/app id
     * @throws IOException
     */
    public void sentHeader() throws IOException {
        output.println(ConnectionProperties.getInstance().getId());
    }

    public void closeConnection() throws IOException {
        output.close();
        socket.close();

    }
}