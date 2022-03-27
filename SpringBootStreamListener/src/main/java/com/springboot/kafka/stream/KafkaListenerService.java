package com.springboot.kafka.stream;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

@Service
@EnableBinding(KafkaListenerBinding.class)
public class KafkaListenerService {
	
	@StreamListener("input-channel-1")
	public void process(KStream<String, String> input) {
		input.foreach((k,v)-> System.out.println("Key:"+k + "Value:"+v));
	}

}
