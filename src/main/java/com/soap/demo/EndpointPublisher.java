package com.soap.demo;

import org.springframework.stereotype.Component;

import com.soap.demo.services.*;

import jakarta.xml.ws.Endpoint;

@Component
public class EndpointPublisher {

    @PostConstruct
    public void publish() {
        System.out.println("Iniciando el servicio");
        String address = "http://0.0.0.0:8081/";
        Endpoint.publish(address, new SOAPImplementacion());
    }
}
