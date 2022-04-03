## Kafka Streams


##### STEP#1: Zookeeper should be running:
<pre>
[1] <b>Navigate:</b> cd /usr/local/kafka/kafka_2.12-2.3.0
[2] <b>Execute:</b> bin/zookeeper-server-start.sh config/zookeeper.properties 
</pre>
*Zookeeper started on port 2181*
![image](https://user-images.githubusercontent.com/45539698/66250650-2892d200-e763-11e9-9a29-2255515a6c16.png)


##### STEP#2:Broker/s should be Running [Here only one]:
<pre>
[1] <b>Navigate:</b> cd /usr/local/kafka/kafka_2.12-2.3.0/config
[2] <b>Create a Broker:</b> cp server.properties server-9092.properties
[3] <b>Edit the Broker[server-9092.properties] with below properties:</b>
    - sudo gedit server-9092.properties
    - broker.id=92
    - listeners=PLAINTEXT://:9092
    - log.dirs=/tmp/kafka-logs-92   
[4] <b>Start the Broker:</b>  
    <b>Navigate:</b> cd /usr/local/kafka/kafka_2.12-2.3.0/
    <b>Execute:</b> bin/kafka-server-start.sh config/server-9092.properties 
</pre>
  
##### STEP#2: Input & Output topics should be Running :
###### Start Input Topic:
<pre>
[1] <b>Navigate:</b> cd /usr/local/kafka/kafka_2.12-2.3.0
[2] <b>Execute:</b> 
    bin/kafka-topics.sh --create \
    --bootstrap-server localhost:9092 \
    --replication-factor 1 \
    --partitions 1 \
    --topic wordcount-input-stream
</pre>

###### Start Output Topic:
<pre>
[1] <b>Navigate:</b> cd /usr/local/kafka/kafka_2.12-2.3.0
[2] <b>Execute:</b>
    bin/kafka-topics.sh --create \
    --bootstrap-server localhost:9092 \
    --replication-factor 1 \
    --partitions 1 \
    --topic wordcount-output-stream \
    --config cleanup.policy=compact
</pre>

##### STEP#3: Producer/Consumer should be Running :
###### Start Producer:
<pre>
[1] <b>Navigate:</b> cd /usr/local/kafka/kafka_2.12-2.3.0
[2] <b>Execute:</b> bin/kafka-console-producer.sh --broker-list localhost:9092 --topic wordcount-input-stream
</pre>
###### Start Consumer:

<pre>
[1] <b>Navigate:</b> cd /usr/local/kafka/kafka_2.12-2.3.0
[2] <b>Execute:</b> 
bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 \
    --topic wordcount-output-stream \
    --from-beginning \
    --formatter kafka.tools.DefaultMessageFormatter \
    --property print.key=true \
    --property print.value=true \
    --property key.deserializer=org.apache.kafka.common.serialization.StringDeserializer \
    --property value.deserializer=org.apache.kafka.common.serialization.LongDeserializer
	       
</pre>



    
