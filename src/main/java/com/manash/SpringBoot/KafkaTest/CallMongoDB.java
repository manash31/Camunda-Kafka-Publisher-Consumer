package com.manash.SpringBoot.KafkaTest;


import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@Service
public class CallMongoDB {

    public void getAllEmp(){

        WebClient client = WebClient.create();

        WebClient.ResponseSpec responseSpec = client.get()
                .uri("http://localhost:8080/rest/api/findAllEmp")
                .retrieve();

        String responseBody = responseSpec.bodyToMono(String.class).block();
        System.out.println(responseBody);


    }


    public void insertEmp(String str){

        MultiValueMap<String, String> bodyValues = new LinkedMultiValueMap<>();


        WebClient client = WebClient.create();
        String response = client.post()
                .uri("http://localhost:8080/rest/api/insertData")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(str)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }


}
