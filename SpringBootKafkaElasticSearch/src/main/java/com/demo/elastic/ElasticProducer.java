package com.demo.elastic;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.springframework.stereotype.Service;


@Service
public class ElasticProducer {
  public String sendMessage(String topic, String title, String category, String operationPath) {
		Client client = Client.create();
		String elasticserverURL="http://localhost:9200";
		WebResource webResource = client.resource(elasticserverURL + operationPath);
		String input = "{\"topic\":\"" + topic + "\",\"title\":\""+ title + "\",\"category\":\"" + category + "\"}";
		ClientResponse response = webResource.type("application/json").post(ClientResponse.class, input);
		return response.getEntity(String.class);

	}

}