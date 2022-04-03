## Practical with Kafka

##### STEP#0: Get Java8:

```
[1] Download jdk-8u221-linux-x64.tar.gz from the Official Website.
[2] Extract jdk-8u221-linux-x64.tar.gz:
    tar -xzvf jdk-8u221-linux-x64.tar.gz
[3] Move Extracted folder (jdk1.8.0_221) to a desired location. In my case I created /usr/local/java [with permissions]:
    mv jdk1.8.0_221 /usr/local/java
[4] Open ~/.bashrc file to set the Environmental Varibles:
    sudo gedit ~/.bashrc	
[5] In the file, mention the below two lines (in the end):
    export JAVA_HOME=/usr/local/java/jdk1.8.0_221
    export PATH=$PATH:/usr/local/java/jdk1.8.0_221/bin
[6] Save the file.
[7] Publish the changes:
    source ~/.bashrc
[8] Check the Java Version: 
    java -version
```
##### STEP#1: Download & Install kafka:
```
[1] Download: kafka_2.12-2.3.0.tgz
[2] Extract: kafka_2.12-2.3.0.tgz:
    kafka_2.12-2.3.0
[3] Move Extracted folder (kafka_2.12-2.3.0) to a desired location. In my case I created /usr/local/kafka [with permissions]:
    mv kafka_2.12-2.3.0 /usr/local/kafka       
```
##### STEP#2: Start Zookeeper:
```
[1] Navigate: cd /usr/local/kafka/kafka_2.12-2.3.0
[2] Execute: bin/zookeeper-server-start.sh config/zookeeper.properties 
```
*Zookeeper started on port 2181*
![image](https://user-images.githubusercontent.com/45539698/66250650-2892d200-e763-11e9-9a29-2255515a6c16.png)


##### STEP#3: Create & Start Multiple Brokers:
```
[1] Navigate: cd /usr/local/kafka/kafka_2.12-2.3.0/config
[2] Now, create multiple Brokers:
    mv server.properties server-0.properties
    cp server-0.propertiess server-1.properties
    cp server-0.propertiess server-2.properties
    cp server-0.propertiess server-3.properties
[3] Now edit the below properties in the above broker files:
    - sudo gedit server-0.properties
    - broker.id=80
    - listeners=PLAINTEXT://:8080
    - log.dirs=/tmp/kafka-logs-80
    --------------------------------
    - sudo gedit server-1.properties
    - broker.id=81
    - listeners=PLAINTEXT://:8081
    - log.dirs=/tmp/kafka-logs-81
    --------------------------------
    - sudo gedit server-2.properties
    - broker.id=82
    - listeners=PLAINTEXT://:8082
    - log.dirs=/tmp/kafka-logs-82
    --------------------------------
    - sudo gedit server-3.properties
    - broker.id=83
    - listeners=PLAINTEXT://:8083
    - log.dirs=/tmp/kafka-logs-83
    --------------------------------
[4] Start all four Brokers.
    - Navigate: cd /usr/local/kafka/kafka_2.12-2.3.0/
    - Execute: bin/kafka-server-start.sh config/server-0.properties 
    
    - Navigate: cd /usr/local/kafka/kafka_2.12-2.3.0/
    - Execute: bin/kafka-server-start.sh config/server-1.properties 
    
    - Navigate: cd /usr/local/kafka/kafka_2.12-2.3.0/  
    - Execute: bin/kafka-server-start.sh config/server-2.properties 
    
    - Navigate: cd /usr/local/kafka/kafka_2.12-2.3.0/ 
    - Execute: bin/kafka-server-start.sh config/server-3.properties 

```
###### List/Check all Brokers: </br>
```
[1] Navigate: cd /usr/local/kafka/kafka_2.12-2.3.0 
[2] Execute: ./bin/zookeeper-shell.sh localhost:2181 ls /brokers/ids
```
![image](https://user-images.githubusercontent.com/45539698/66376861-21bbc780-e9ce-11e9-9b9f-9fb26b299e35.png)

##### STEP#4: Create Topic-Choose any Broker from [`80`, `81`, `82`, `83`]:
###### Example1: Let us create 1 topic (topic82) with 4 partitions and 4 replicas on Broker#82, running on 8082
```
[1] Navigate: cd /usr/local/kafka/kafka_2.12-2.3.0
[2] Execute: bin/kafka-topics.sh --create --bootstrap-server localhost:8082 --replication-factor 4 --partitions 4 --topic topic82
```
###### Viewing Status/Summary:
```
[1] Navigate: cd /usr/local/kafka/kafka_2.12-2.3.0/bin
[2] Execute: ./kafka-topics.sh --describe --zookeeper localhost:2181 --topic topic82
```
![image](https://user-images.githubusercontent.com/45539698/66378693-a52ae800-e9d1-11e9-9fa6-0a2922e131f5.png)

###### Example2: Let us create 3 topics (topic83-1, topic83-2, topic83-3) with 4 partitions and 4 replicas each on Broker#83 , running on 8083
```
[1] Navigate: cd /usr/local/kafka/kafka_2.12-2.3.0
[2] Execute: bin/kafka-topics.sh --create --bootstrap-server localhost:8083 --replication-factor 4 --partitions 4 --topic topic83-1
[3] Execute: bin/kafka-topics.sh --create --bootstrap-server localhost:8083 --replication-factor 4 --partitions 4 --topic topic83-2
[4] Execute: bin/kafka-topics.sh --create --bootstrap-server localhost:8083 --replication-factor 4 --partitions 4 --topic topic83-3
```
###### Viewing Status/Summary:
```
[1] Navigate: cd /usr/local/kafka/kafka_2.12-2.3.0/bin
[2] Execute: ./kafka-topics.sh --describe --zookeeper localhost:2181 --topic topic83-1
[3] Execute: ./kafka-topics.sh --describe --zookeeper localhost:2181 --topic topic83-2
[4] Execute: ./kafka-topics.sh --describe --zookeeper localhost:2181 --topic topic83-3
```
![image](https://user-images.githubusercontent.com/45539698/66378818-ef13ce00-e9d1-11e9-8263-83304b842c08.png)

###### List of all Topics: </br>
```
[1] Navigate: cd /usr/local/kafka/kafka_2.12-2.3.0 
[2] Execute: bin/kafka-topics.sh --list --zookeeper localhost:2181 
```
##### STEP#5: Create Producer:
```
[1] Navigate: cd /usr/local/kafka/kafka_2.12-2.3.0
[2] Execute: bin/kafka-console-producer.sh --broker-list localhost:8082 --topic topic82
```

##### STEP#6: Create Consumer:
```
[1] Navigate: cd /usr/local/kafka/kafka_2.12-2.3.0
[2] Execute:  bin/kafka-console-consumer.sh --bootstrap-server localhost:8082 --topic topic82 --from-beginning
```

##### STEP#7: Now send something from Producer and observe Consumer Terminal:

![image](https://user-images.githubusercontent.com/45539698/66397406-64df6000-e9f9-11e9-960b-11ff072ecc82.png)


<hr>

***GREAT POINTS TO NOTE:***
___________________

*[1] We cannot create a topic with 0 Partitions.* </br>
*[2] We cannot create a topic with 0 Replicas* </br>
*[3] We cannot create a topic with 0 Partitions & 0 Replicas* </br>

*[4] WHAT IF - TOPIC CREATION HOST IS DIFFERENT FROM PRODUCER/CONSUMER:* </br>

![image](https://user-images.githubusercontent.com/45539698/66483187-38434b00-eac2-11e9-8cbc-bc7d80fd7633.png)
*So far, we created  topics, producers and consumers on same broker(port).The topic replicas floated around in the cluster. Now, let us consider a situation:*
 - *Create a topic with only 1 Replica and 1 Partition. The newly created topic will get created on any broker randomly (Here: 8082).* </b>
 - *Create a producer on 8080.* </br>
 - *Create a consumer on 8080. Then 8082.* </br>
*OBSERVATION: Internally, all brokers are inter-communicating & inter-connected with Zookeeper & Kafka cluster.Therefore computing is abstracted.* </br>

*[5] WHAT IF - PRODUCER HOSTING ON RANDOM TOPIC:* </br>
```
bin/kafka-console-producer.sh --broker-list localhost:8080 --topic topicfrommoon
```
![image](https://user-images.githubusercontent.com/45539698/66460800-49c22e00-ea95-11e9-8876-0820bd5f5808.png)
*OBSERVATION: The Topic (**topicfrommoon**) gets prepard on run-time, with one partition. This can be verified by:*
```
[1] Navigate: cd /usr/local/kafka/kafka_2.12-2.3.0
[2] Execute: bin/kafka-topics.sh --list --zookeeper localhost:2181
[3] Navigate: cd /usr/local/kafka/kafka_2.12-2.3.0/bin
[4] ./kafka-topics.sh --describe --zookeeper localhost:2181 --topic topicfrommoon
```
![image](https://user-images.githubusercontent.com/45539698/66472418-d5928500-eaaa-11e9-82e8-c80f2a56d78c.png)


*[6] WHAT IF - CONSUMER LISTENING ON RANDOM TOPIC:* </br>
```
 bin/kafka-console-consumer.sh --bootstrap-server localhost:8080 --topic topicfromvenus --from-beginning
```
![image](https://user-images.githubusercontent.com/45539698/66461729-4c258780-ea97-11e9-9394-6ed432b73d48.png)
*OBSERVATION1: The Topic (**topicfromvenus**) gets prepard on run-time, which can be listed using: **bin/kafka-topics.sh --list --zookeeper localhost:2181*** *OBSERVATION2: Consumer keeps waiting on topicfromvenus, till it receives any data*

*[7] WHAT IF - NO. OF REPLICAS > NO. OF BROKERS:* </br>
![image](https://user-images.githubusercontent.com/45539698/67097411-afba5e00-f1d7-11e9-9dc5-d106a27a28c7.png)
<hr>

## KAFKA-CONNECT:

##### Kafka Connect is used to move data from one source to another. Below we are movig data present in a file to another using Kafka-Connect.
```
[1] Create a source file [Any location | With Permissions | With some data].
[2] Create a blank file [Any location | With Permissions]
[3] Give the path of source file in: /usr/local/kafka/kafka_2.12-2.3.0/config/connect-file-source.properties
[4] Give the path of destination file in: /usr/local/kafka/kafka_2.12-2.3.0/config/connect-file-sink.properties
[5] Give any RUNNING broker port number in: /usr/local/kafka/kafka_2.12-2.3.0/config/connect-standalone.properties
[6] Navigate: cd /usr/local/kafka/kafka_2.12-2.3.0/
[7] Execute: bin/connect-standalone.sh config/connect-standalone.properties config/connect-file-source.properties config/connect-file-sink.properties

OBSERVATION: 
 - The data in souce.txt has been moved into destination.txt.
 - If you keep adding stuff in source.txt, the changes won't reflect in real time on destination.txt.Kafka Connect hold Batch Properties.
 - The data has been moved via topic (connect-test) mentioned in [connect-file-source.properties] & [connect-file-sink.properties].
```  
![image](https://user-images.githubusercontent.com/45539698/66560083-46ea3a80-eb74-11e9-8949-ffe33004eba3.png)
![image](https://user-images.githubusercontent.com/45539698/66560504-2a023700-eb75-11e9-979b-5e2312b86d4a.png)
###### To view any data on any topic (Not Limited to Kafka-Connect):
```
bin/kafka-console-consumer.sh --bootstrap-server localhost:8082 --topic connect-test --from-beginning
```
![image](https://user-images.githubusercontent.com/45539698/66562637-af87e600-eb79-11e9-8e4d-72e753101aa2.png)

