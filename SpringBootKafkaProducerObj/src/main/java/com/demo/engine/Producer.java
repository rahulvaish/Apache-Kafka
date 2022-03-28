package com.demo.engine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.demo.model.Address;
import com.demo.model.Person;

@Service
public class Producer {

    private static final Logger logger = LoggerFactory.getLogger(Producer.class);

    @Autowired
    private KafkaTemplate<String, Person> kafkaTemplate;

    public void sendInfo(String topic, String personName, String city, String country ) {
        System.out.print("#### -> Producing message on:"+topic +"|"+ personName + "|"+ city + "|" + country );
        Address address = new Address();
        address.setCity(city);
        address.setCountry(country);
        
        Person person  = new Person();
        person.setPersonName(personName);
        person.setAddress(address);
        
        this.kafkaTemplate.send(topic, person);
    }
}
