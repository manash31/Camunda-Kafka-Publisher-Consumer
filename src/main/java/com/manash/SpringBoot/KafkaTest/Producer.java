package com.manash.SpringBoot.KafkaTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessageToTopic(String msg){
        System.out.println("Sending Message To Topic");
        kafkaTemplate.send("Things-To-Do",msg);
    }
}