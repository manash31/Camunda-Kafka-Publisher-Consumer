package com.manash.SpringBoot.KafkaTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/api")
public class KafkaController {

    @Autowired
    Producer producer;

    @Autowired
    CallMongoDB callMongoDB;

    @GetMapping("/producerMessage")
    public void getMessageFromKafkaClient(@RequestParam("message") String message){

        producer.sendMessageToTopic(message);
    }

    @PostMapping(path = "/AddEmpViaMsg")
    public void sendMessageToKafkaTopic(@RequestBody String message) {
        callMongoDB.insertEmp(message);
    }


    @GetMapping(value = "/product")
    public void getProduct()
    {
        System.out.println("Hello");
    }

    @PostMapping(path = "/AddEmp")
    public void create(@RequestBody String newEmp) {
        callMongoDB.insertEmp(newEmp);

    }

}
