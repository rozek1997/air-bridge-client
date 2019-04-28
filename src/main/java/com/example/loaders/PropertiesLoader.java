package com.example.loaders;

import com.example.pojo.ConnectionProperties;

import java.io.*;
import java.util.Properties;

public class PropertiesLoader {


    private Properties properties;
    private  String propertyFilePath;

    public PropertiesLoader(String propertyFilePath){
        properties = new Properties();
        this.propertyFilePath=propertyFilePath;

    }

    /**
     * load property file from propertyFilePath
     * @throws IOException
     */
    public void loadProperties() throws IOException {
        InputStream inputStream = new FileInputStream(new File(propertyFilePath));
        if (inputStream != null)
            properties.load(inputStream);
        else {
            throw new FileNotFoundException();
        }


        /*
         * set connection properties singleton instance with properties readed from property file
         */
        ConnectionProperties.getInstance().setHostname(properties.getProperty("hostname"));
        ConnectionProperties.getInstance().setPort(Integer.parseInt(properties.getProperty("port")));
        ConnectionProperties.getInstance().setId(properties.getProperty("id"));
    }


}
