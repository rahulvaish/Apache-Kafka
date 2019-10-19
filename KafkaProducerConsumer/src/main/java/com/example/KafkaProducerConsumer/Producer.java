package com.example.KafkaProducerConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
public class Producer {

	public static void main(String[] args) throws InterruptedException {
		 String topic = "topic82";
	        String brokers = "localhost:8082";
	        String StringSerializer = "org.apache.kafka.common.serialization.StringSerializer";

	        Random rnd = new Random();

	        Map<String, Object> config = new HashMap<String, Object>();
	        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, brokers);
	        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer);
	        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer);


	        KafkaProducer producer = new KafkaProducer<String, String>(config);

	        while (true) {
	            LocalDateTime runtime = LocalDateTime.now();
	            String msg = runtime + " "+ rnd.nextInt(255);
	            ProducerRecord record = new ProducerRecord<String, String>(topic, msg);
	            producer.send(record);
	            Thread.sleep(100);
	        }

	}

}
