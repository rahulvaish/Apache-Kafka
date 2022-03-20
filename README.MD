This repository contains Apache Kafka Examples.


### Table of Contents
- <a href='#kafka-installation'>Kafka Installation</a>
  - <a href='#kafka-installation-and-setup'>Kafka Installation and SetUp</a>
- <a href='#kafka-implementations'>Kafka Implementations</a> 
  - <a href='#kafka-producer-consumer'>Kafka Producer Consumer</a> 
  - <a href='#springboot-kafka'>SpringBoot-Kafka</a> 
  - <a href='#springboot-kafka-elasticsearch'>SpringBoot-Kafka-ElasticSearch</a> 
  - <a href='#KafkaStreams-producer-consumer'>KafkaStreams Producer Consumer</a>
### Confluent Kafka
- [Confluent Kafka Installation & SetUp](https://github.com/rahulvaish/Apache-Kafka/blob/confluentKafka/%5B01%5D%20SetUpConfluentKafka.MD)


<hr>

- ###### [Kafka Installation and SetUp](https://github.com/rahulvaish/Apache-Kafka/blob/KafkaEnvironment/InstallingKafkaOnUbuntu.MD) 
   ###### This [document](https://github.com/rahulvaish/Apache-Kafka/blob/KafkaEnvironment/InstallingKafkaOnUbuntu.MD) is a step by step guide to install and configure the Kafka infrastructure. This document also contains a few R&D scenerios. To run Kafka on Docker refer this [document](https://github.com/rahulvaish/Apache-Kafka/blob/KafkaEnvironment/KafkaOnDocker.MD).
   
<hr>
 
- ###### [Kafka Producer Consumer](https://github.com/rahulvaish/Apache-Kafka/tree/KafkaProducerConsumer) 
   ###### Prerequisite: Kafka should be Up & Running. To setup Kafka infrastructure, refer this [document](https://github.com/rahulvaish/Apache-Kafka/blob/KafkaEnvironment/InstallingKafkaOnUbuntu.MD).
   ###### This example illustrates a simple implementation of Kafka mechanics in Java, where Kafka Producer is producing Timestamp on a topic, and Consumer consuming the same.

<hr>

- ###### [SpringBoot-Kafka](https://github.com/rahulvaish/Apache-Kafka/tree/SpringBootKafka) 
   ###### Prerequisite: Kafka should be Up & Running. To setup Kafka infrastructure, refer this [document](https://github.com/rahulvaish/Apache-Kafka/blob/KafkaEnvironment/InstallingKafkaOnUbuntu.MD).
   ###### This example illustrates a simple SpringBoot implementation where a JSON is fed to Kafka Producer for a topic, and Consumer listens the same.
![image](https://user-images.githubusercontent.com/689226/67137118-c7342e00-f24d-11e9-890e-faf1505e40f0.png)

<hr>

- ###### [SpringBoot-Kafka-ElasticSearch](https://github.com/rahulvaish/Apache-Kafka/tree/SpringBootKafkaES)
   ###### Prerequisite: Kafka should be Up & Running. To setup Kafka infrastructure, refer this [document](https://github.com/rahulvaish/Apache-Kafka/blob/KafkaEnvironment/InstallingKafkaOnUbuntu.MD).
   ###### This example illustrates a simple SpringBoot implementation where a JSON is fed to Kafka Producer for a topic, and Consumer listens the same, aslo then forwards the input to ES Server.
![image](https://user-images.githubusercontent.com/689226/67137229-6f96c200-f24f-11e9-8fcf-a01308877503.png)
   ###### From ES Server:
![image](https://user-images.githubusercontent.com/689226/67137241-8c32fa00-f24f-11e9-939b-db930a7d5af7.png)


<hr>

- ###### [KafkaStreams-Producer-Consumer](https://github.com/rahulvaish/Apache-Kafka/tree/KafkaStreamProducerConsumer) 
   ###### Prerequisite: Kafka should be Up & Running. To setup Kafka Stream infrastructure, refer this [document](https://github.com/rahulvaish/Apache-Kafka/blob/KafkaEnvironment/KafkaStreamsSetUp.MD).
   ###### This example illustrates a simple implementation of Kakfa Stream API -  where data is fed into the Input Stream and its word count is computed. 
   
<hr>


