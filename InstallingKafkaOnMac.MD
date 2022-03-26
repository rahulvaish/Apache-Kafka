## Kafka SetUp on Mac

##### STEP#0: Get Java8.
##### STEP#1: Install Kafka:
```
brew install kafka
```
##### STEP#2: Start Zookeeper:
```
zookeeper-server-start /opt/homebrew/etc/kafka/zookeeper.properties
```
<img width="1727" alt="image" src="https://user-images.githubusercontent.com/689226/160221475-5be11bb1-c829-460d-8d97-d84eb83bb13f.png">

##### STEP#3: Start Kafka:
```
kafka-server-start /opt/homebrew/etc/kafka/server.properties
```
<img width="1699" alt="image" src="https://user-images.githubusercontent.com/689226/160221496-1c1d3667-23bc-49b1-9b3d-b1bfd3f913a9.png">

##### STEP#4: Create Kafka Topic:
```
kafka-topics --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic foobar
```
##### STEP#5: Create Kafka Producer:
```
kafka-console-producer --broker-list localhost:9092 --topic foobar
```
##### STEP#6: Create Kafka Consumer:
```
kafka-console-consumer --bootstrap-server localhost:9092 --topic foobar --from-beginning
```
<img width="1622" alt="image" src="https://user-images.githubusercontent.com/689226/160221534-de66a35f-792a-4d3f-b71a-b6bfdeb7e9b2.png">
