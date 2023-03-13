package com.manash.SpringBoot.KafkaTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class KafkaTestApplication {



	public static void main(String[] args) {
		CallMongoDB callMongoDB = new CallMongoDB();
		//callMongoDB.wcPost2();
		//callMongoDB.wcPost();
		SpringApplication.run(KafkaTestApplication.class, args);
	}


}
