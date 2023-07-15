package com.javatpoint.server.main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan(basePackages = "com.")
@SpringBootApplication
public class RestfulWebServicesApplication 
{
public static void main(String[] args) 
{
SpringApplication.run(RestfulWebServicesApplication.class, args);
}
}