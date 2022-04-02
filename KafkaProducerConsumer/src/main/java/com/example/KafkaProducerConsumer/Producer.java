package com.example.KafkaProducerConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.IntegerSerializer;

import java.util.HashMap;
import java.util.Map;
public class Producer {

	public static void main(String[] args) throws InterruptedException {
		 String topic = "foobar";
	        String brokers = "localhost:9092";
		    String IntegerSerializer = "org.apache.kafka.common.serialization.IntegerSerializer";
	        String StringSerializer = "org.apache.kafka.common.serialization.StringSerializer";

	        Map<String, Object> config = new HashMap<String, Object>();
	        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, brokers);
	        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer);
	        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer);

	        KafkaProducer<Integer,String> producer = new KafkaProducer<>(config);

			System.out.println("PUBLISHING STARTED");
	        for(int i=0;i< 10;i++){
	            producer.send(new ProducerRecord(topic, i, "MSG#"+i));
	        }
			producer.close();
			System.out.println("PUBLISHING ENDED");
	}

}
