package com.demo.controllers;

import com.demo.engine.Producer;
import com.demo.model.MessageTopicModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

    private final Producer producer;

    @Autowired
    KafkaController(Producer producer) {
        this.producer = producer;
    }

    @RequestMapping("/")
    public String welcome() {
        return "Welcome To Kafka Producer-Consumer Application";
    }
    
    @RequestMapping(value = "/publish/", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public String sendMessageToKafkaTopic(@RequestBody MessageTopicModel messagetopic) {
    	this.producer.sendMessage(messagetopic.getTopic(), messagetopic.getMessage());
    	return "Message has been posted on Topic "+messagetopic.getTopic();
    }
    
}
