# AirBridge client

This project consist of two repos
Another repo of server written in is available at
[AirBridge server](https://github.com/rozek1997/air-bridge-server)

## Project aim 

Project aim was to make client - server model using two programming languages. <br>

## Short description
For this purpose two application, client and server, in Java and C respectively have been written and connected via websocket. <br>
Client is build in java. When you want to send file to server, first of all you need to write very simple property file with few attributes

* hostname="ip adress of server"
* port="port on which we connecting to server"
* id="name of our client"


### Compliling application 
In folder where pom.xml is included <br>
`$ mvn clean install` <br>
## Running application

You need to provide 2 arguments: 
* -pf --property "absolute path to property file which you wrote earlier"
* -i --input "absolute path to file we want to send to the server"

Whole command:
* `cd target`
* `$ java -jar client-java-1.0-jar-with-dependencies.jar -pf [path/to/property/file] -i [filepath/to/file]`



