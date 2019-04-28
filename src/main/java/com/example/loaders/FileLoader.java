package com.example.loaders;

import java.io.*;

public class FileLoader{

    private BufferedReader fileReader;
    private String filePath;

    /**
     * Load file from filePath
     */
    public FileLoader(String filePath) throws FileNotFoundException {
        this.filePath=filePath;
        fileReader=new BufferedReader(new FileReader(new File(filePath)));
    }

    public BufferedReader getFileReader() {
        return fileReader;
    }
}