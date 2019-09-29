### Installation of Kafka on Ubuntu.
<hr>

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

##### STEP#1: Download Apache Kafka:
```
wget http://mirrors.estointernet.in/apache/kafka/2.3.0/kafka_2.12-2.3.0.tgz
```
##### STEP#2: Unzip Apace Kafka: 
```
tar -xzf kafka_2.12-2.3.0.tgz
```
##### STEP#3: Move Extracted folder (kafka_2.12-2.3.0) to a desired location. In my case I created /usr/local/kafka [with permissions]:
```     
mv kafka_2.12-2.3.0 /usr/local/kafka
```
##### STEP#4: Start the Zookeeper (Zookeeper manages brokers on Distributed System):
```
**rahul@rahul-VirtualBox:/usr/local/kafka/kafka_2.12-2.3.0$** bin/zookeeper-server-start.sh config/zookeeper.properties
```
![image](https://user-images.githubusercontent.com/45539698/65813293-02b07f00-e1f1-11e9-8921-09815b43ab47.png) </br>
*Zookeeper is started on Port is 2181* 

##### STEP#5: Start the Kafka Server/Broker:
```
**rahul@rahul-VirtualBox:/usr/local/kafka/kafka_2.12-2.3.0$** bin/kafka-server-start.sh config/server.properties
```
![Capture1](https://user-images.githubusercontent.com/45539698/65813431-bc5c1f80-e1f2-11e9-8336-085dfe065312.JPG) </br>
*Kafka broker started on port is  9092*

###### The insallation activity is completed.
