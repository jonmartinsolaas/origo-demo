# Oslo Bysykkel API demo

## Introduction

This is a simple application demonstrating consumption 
of Oslo Bysykkel API. (https://oslobysykkel.no/apne-data/sanntid)

The application is Java based and uses Feign Rest Client and Hystrix 
Circuit Breaker from Spring Boot and Spring Cloud. In addition there is a simple Web 
GUI based on Vaadin Flow. 

The application does only display number of free bikes and locks on the
stations provided by the API in the order presented by the API. 

## How to build and run

### Requirements

- Java JDK 11 
- Maven 3.6
- A fairly updated web browser

### Build and run

You can run the application in Maven (developers mode):

`$ mvn clean package spring-boot:run`

You can also build a distributable jar file 

`$ mvn clean package -PproductionMode=true`

and run it

`$ java -jar target/origo-demo-0.0.1-SNAPSHOT.jar`

In both cases the app will be available at http://localhost:8080

##Configuration

There is only one configuration parameter; the url to the REST api: 

`oslobysykkel-rest.url=https://gbfs.urbansharing.com/oslobysykkel.no`

This is stored in the `application.properties` file. You can provoke 
Hystrix into action by messing with the url.
