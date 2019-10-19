package com.demo.engine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private static final Logger logger = LoggerFactory.getLogger(KafkaProducer.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String sequence,String title, String topic, String category) {
        logger.info(String.format("KAFKA PRODUCER - PRODUCING MESSAGE"));
        String seqTitleCategory = sequence+","+title+","+category;
        this.kafkaTemplate.send(topic, seqTitleCategory);
    }
}
