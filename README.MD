This repository contains Apache Kafka Examples.


### Table of Contents
- <a href='#kafka-installation'>Kafka Installation</a>
  - [Kafka Installation on Ubuntu](https://github.com/rahulvaish/Apache-Kafka/blob/KafkaEnvironment/InstallingKafkaOnUbuntu.MD)
  - [Kafka Installation on Docker](https://github.com/rahulvaish/Apache-Kafka/blob/KafkaEnvironment/KafkaOnDocker.MD)
  - [Kafka Installation on Mac](https://github.com/rahulvaish/Apache-Kafka/blob/KafkaEnvironment/InstallingKafkaOnMac.MD)
  - [Confluent Kafka Installation on Mac](https://github.com/rahulvaish/Apache-Kafka/blob/confluentKafka/%5B01%5D%20SetUpConfluentKafka.MD)
  - [Kafka Basic Concepts](https://github.com/rahulvaish/Apache-Kafka/blob/KafkaEnvironment/KafKaBasics.MD)
- <a href='#kafka-implementations'>Kafka Implementations</a> 
  - <a href='#java-kafka-producer-consumer'>Java-Kafka-Producer-Consumer</a> 
  - <a href='#java-kafka-producer-multithreading'>Java-Kafka-Producer-Multithreading</a> 
  - <a href='#springboot-kafka-producer'>SpringBoot-Kafka-Producer</a> 
  - <a href='#springboot-kafka-producer-object'>SpringBoot-Kafka-Producer-Object</a> 
  - <a href='#springboot-kafka-stream-listener'>SpringBoot-Kafka-Stream-Listener</a> 
  - <a href='#java-kafka-stream'>Java-Kafka-Stream</a> 


<hr>

 
- ###### [Java-Kafka-Producer-Consumer](https://github.com/rahulvaish/Apache-Kafka/tree/KafkaProducerConsumer) 
   ###### This example illustrates a simple implementation of Producer & Consumer using kafka.

<hr>

- ###### [Java-Kafka-Producer-Multithreading](https://github.com/rahulvaish/Apache-Kafka/tree/KafkaProducerMultiThreading)
   ###### This example illustrates creating single Producer and & multi threads producing data on single topic
   ![image](https://user-images.githubusercontent.com/689226/161403837-ddafaff6-baa2-419a-a220-a1c8ab6fddc4.png)

   <img width="1144" alt="image" src="https://user-images.githubusercontent.com/689226/161403716-5897eded-0235-4a32-97ef-53cfe5470526.png">

<hr>

- ###### [Springboot-Kafka-Producer](https://github.com/rahulvaish/Apache-Kafka/tree/SpringBootKafkaProducer) 
   ###### This example illustrates a simple SpringBoot project producing data (string) on Kafka topic.
   <img width="662" alt="image" src="https://user-images.githubusercontent.com/689226/160305058-88d10f0c-25a8-43b3-a29d-b04ac68e9b94.png">
   <img width="1383" alt="image" src="https://user-images.githubusercontent.com/689226/160305090-9cd52b4a-b501-4962-8391-ce0473df01da.png">
   <img width="980" alt="image" src="https://user-images.githubusercontent.com/689226/160310221-4a2450e2-8fdb-4df6-b14f-67e2c99bb32a.png">

<hr>

- ###### [SpringBoot-Kafka-Producer-Object](https://github.com/rahulvaish/Apache-Kafka/tree/SpringBootKafkaProducerObj) 
   ###### This example illustrates a simple SpringBoot project producing data (object) on Kafka topic. 
   <img width="615" alt="image" src="https://user-images.githubusercontent.com/689226/160309874-6e226144-cc33-456d-8018-39a4f509be64.png">
   <img width="1372" alt="image" src="https://user-images.githubusercontent.com/689226/160309998-0ed17369-22eb-40a2-9c22-d0df0c5e5039.png">
   <img width="1346" alt="image" src="https://user-images.githubusercontent.com/689226/160310083-0658f371-60a2-4159-809b-de2651e95f9d.png">


<hr>

- ###### [SpringBoot-Kafka-Stream-Listener](https://github.com/rahulvaish/Apache-Kafka/tree/SpringBootStreamListener) 
   ###### This example illustrates a simple SpringBoot App Listening a Kafka topic.
   <img width="575" alt="image" src="https://user-images.githubusercontent.com/689226/160305169-4b4fabb0-cfa2-45fd-ad14-fbc46909cdd0.png">

<hr>

- ###### [Java-Kafka-Stream](https://github.com/rahulvaish/Apache-Kafka/tree/JavaKafkaStream) 
   ###### This example illustrates a simple Java Stream App that reads data from a topic, processes it and sends the output to another topic (using Stream APIs)
   <img width="1520" alt="image" src="https://user-images.githubusercontent.com/689226/161452322-914f6d59-5342-47b0-b19f-a5a5083dc431.png">
   <img width="1516" alt="image" src="https://user-images.githubusercontent.com/689226/161452294-26414350-db76-4320-84ba-37398395d62e.png">
   We produce data on topicA. The App reads data from topicA. It data contains "a", it sends the data to topicB
   
   <img width="1038" alt="image" src="https://user-images.githubusercontent.com/689226/161452384-154d5048-6bdf-4e57-ad7e-3604a67444c3.png">
   <img width="1083" alt="image" src="https://user-images.githubusercontent.com/689226/161452398-4082be8a-1ffb-4158-8d5e-5b2959524c74.png">

   


