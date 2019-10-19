package com.demo.controllers;

import com.demo.elastic.ElasticProducer;
import com.demo.model.InputModel;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping(value = "/elastic")
public class ElasticController {

	private final ElasticProducer elasticProducer;

	@Autowired
	ElasticController(ElasticProducer elasticProducer) {
		this.elasticProducer = elasticProducer;
	}

	@RequestMapping(value = "/elasticsearch/", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public String sendMessageToElasticServer(@RequestBody InputModel input) {	
		String sequence = input.getSequence();
		String title = input.getTitle();
		String category = input.getCategory();
		this.elasticProducer.sendMessage(input.getTopic(), title, category, "/hw/mv/"+sequence);
		return "Message has been posted on ES ";
	}

}
