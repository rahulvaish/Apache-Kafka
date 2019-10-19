package com.demo.engine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import java.io.IOException;

@Service
public class KafkaConsumer {

    private final Logger logger = LoggerFactory.getLogger(KafkaProducer.class);

    @KafkaListener(topics = "users", groupId = "group_id")
    public void consume(String seqTitleCategory) throws IOException {
        logger.info(String.format("CONSUMER - CONSUMED MESSAGE"));
        
        Client client = Client.create();
		String elasticserverURL="http://localhost:9000";
		WebResource webResource = client.resource(elasticserverURL + "/elastic/elasticsearch/");
		String[] messagesplit = seqTitleCategory.split(",");
		String sequence = messagesplit[0];
		String title = messagesplit[1];
		String category = messagesplit[2];
		String input = "{\"topic\":\"" + "users" + "\",  \"sequence\":\"" + sequence +"\"  ,\"title\":\""+ title + "\",\"category\":\"" + category + "\"}";
		ClientResponse response = webResource.type("application/json").post(ClientResponse.class, input);
		        
    }
}
