package com.example.springbootsimplesoap.endpoint;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.InputSOATest;
import com.example.ObjectFactory;
import com.example.OutputSOATest;

@Endpoint
public class HelloWorldWebServiceEndpoint {

    private static final String NAMESPACE_URI = "http://example.com";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "inputSOATest")
    @ResponsePayload
    public OutputSOATest helloWorld(@RequestPayload InputSOATest inputSOATest) {

        String outputString = "Hello " + inputSOATest.getTest() + "!";

        ObjectFactory objectFactory = new ObjectFactory();
        final OutputSOATest outputSOATest = objectFactory.createOutputSOATest();

        outputSOATest.setResult(outputString);

        return outputSOATest;

    }

}
