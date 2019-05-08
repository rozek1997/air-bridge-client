package com.example;

import com.example.connection.Connection;
import com.example.loaders.FileLoader;
import com.example.loaders.PropertiesLoader;
import org.apache.commons.cli.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class Main {


    private CommandLine cmd;


    public Main(String[] args) {

        try {
            readCommandLineArgs(args);
            readPropertyFile();
            connectAndSend();

        } catch (IOException | InterruptedException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }


    /**
     * read command line arguments
     * @param args
     *  --input -i
     *  --pf property
     */
    public void readCommandLineArgs(String[] args) {
        Options options = new Options();

        Option input = new Option("i", "input", true, "input file path");
        input.setRequired(true);
        options.addOption(input);

        Option properties = new Option("pf", "property", true, "property file path");
        properties.setRequired(true);
        options.addOption(properties);

        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("utility-name", options);

            System.exit(1);
        }


    }

    /**
     * Read property file
     * @throws IOException
     */
    public void readPropertyFile() throws IOException {
        PropertiesLoader propertiesLoader = new PropertiesLoader(cmd.getOptionValue("property"));
        propertiesLoader.loadProperties();
    }

    public static void main(String[] args) {

        new Main(args);

    }

    /**
     * establish connection and sent data from file specified in input args parameters via sockets
     *
     * @throws IOException
     * @throws InterruptedException
     */
    public void connectAndSend() throws IOException, InterruptedException {
        Connection connection = new Connection();
        connection.connect();
        FileLoader fileLoader = new FileLoader(cmd.getOptionValue("input"));
        connection.sentHeader();
        TimeUnit.SECONDS.sleep(2);
        String stringToSend;
        while ((stringToSend = fileLoader.getFileReader().readLine()) != null) {
//            System.out.println(stringToSend);
            connection.sendData(stringToSend);
        }
        System.out.println("Data sent");
        connection.closeConnection();
    }


}

