package com.example.KafkaProducerConsumer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class Dispatcher implements Runnable{
	
	private KafkaProducer<Integer,String> producer;
	private String topicName;
	
	
	Dispatcher(KafkaProducer<Integer,String> producer , String topicName){
		this.producer = producer;
		this.topicName = topicName;
	}

	@Override
	public void run() {
		for(int i=0;i< 10;i++){
            producer.send(new ProducerRecord<>(topicName, i, "Message#"+i+"from Thread#"+Thread.currentThread().getName()));
        }		
	}
}
