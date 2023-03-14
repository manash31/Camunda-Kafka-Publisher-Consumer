package com.manash.SpringBoot.KafkaApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    @Autowired
    CallMongoDB callMongoDB;
    @KafkaListener(topics = {"Camunda-AuditTrail-events"}, groupId = "A")
    public void listenToTopic(String recieveMsg){
        System.out.println("Message Recieved::::"+recieveMsg);
        callMongoDB.insertEmp(recieveMsg);
    }
}