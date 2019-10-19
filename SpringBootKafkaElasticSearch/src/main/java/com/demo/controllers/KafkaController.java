package com.demo.controllers;

import com.demo.engine.KafkaProducer;
import com.demo.model.InputModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

    private final KafkaProducer producer;

    @Autowired
    KafkaController(KafkaProducer producer) {
        this.producer = producer;
    }

    @RequestMapping("/")
    public String welcome() {
        return "Welcome To Kafka Producer-Consumer Application";
    }
    
    @RequestMapping(value = "/publish/", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public String sendMessageToKafkaTopic(@RequestBody InputModel input) {
    	this.producer.sendMessage(input.getSequence(),input.getTitle(), input.getTopic(), input.getCategory());
    	return "Message has been posted on Topic "+input.getTopic();
    }
    
}
