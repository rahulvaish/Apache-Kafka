# Kafka Cluster:
<img width="564" alt="image" src="https://user-images.githubusercontent.com/689226/161364491-bf3d6376-ac81-4bd5-b101-5ea91d5b0400.png">
A Kafka cluster is a distributed architecture - However, it does not follows master - slave architecture. Instesd a Kafka cluster is managed by zookeeper. 

![image](https://user-images.githubusercontent.com/689226/159184196-4fcff60b-12d5-497e-9158-b922af3e864f.png)
*Example of 4 Brokers Cluster [Linux Doc](https://github.com/rahulvaish/Apache-Kafka/blob/KafkaEnvironment/InstallingKafkaOnUbuntu.MD):*\
<img width="895" alt="image" src="https://user-images.githubusercontent.com/689226/159185389-b4becb3b-2dfb-448b-8e15-1c36811e4c72.png">

# Controller:
- The fist broker of the cluster becomes the controller.
- It is just a normal broker + aditional responsibilities.
- There is only one of controller in the cluster.
- All brokers keep an eye on controller broker in the zookeeper, when it dies, any other broker is chosen to become next controller.
  (This ensures there is always one controller)
- Zookeeper maintains the list of active Brokers. 
- Controller montitors the list of active Brokers. 
- Controller is also responsible to assign the task b/w brokers.

<hr>

### 3 Brokers | 2 Topics | Topic1 -> 3 Partitions | Topic2 -> 2 Partitions | ReplicationFactor = 2

![image](https://user-images.githubusercontent.com/689226/159184416-da090a5a-f13c-4a61-a7aa-b64e711e0265.png)

![image](https://user-images.githubusercontent.com/689226/159184567-420b3854-2a71-4077-9b06-0907cfc7e6eb.png)

![image](https://user-images.githubusercontent.com/689226/159184819-fc9df8bb-b927-4815-a612-5b0b3c28f903.png)

*Example:*
<img width="1010" alt="image" src="https://user-images.githubusercontent.com/689226/159184957-8078576b-ab24-4022-b56e-ba0e421a47ec.png">


<hr>

![image](https://user-images.githubusercontent.com/689226/159184843-7b96349a-a8dd-41f3-a442-922d8ec9c620.png)

![image](https://user-images.githubusercontent.com/689226/159184849-0fb02300-d41e-49dd-8773-f8997696fae7.png)

- A Topic has *n* partitionings, when Producer publishes data on the topic, the data goes and resides in one of the partition.

- **Case1**: When you associate a Key along with Value -> The hash of the key is calculated and according to the result the the partition is chosen for data to reside.

- **Case2**: When you do not associate a Key along with Value -> The data goes in Round Robin fashion amongst the various partitions. 
```
FunExperimentExample: Add multiple messages with key as "abc", let say the resultant # will point to Partition2.
Add n data to a topic, and on search you will find all n data items will be landing on Partition2.
```

<hr>

![image](https://user-images.githubusercontent.com/689226/159184869-2d70a9d0-e474-428c-98b6-4a1a7b0e2e64.png)

![image](https://user-images.githubusercontent.com/689226/159184873-b2a09ce6-2b38-41a6-8f55-d58f00146f45.png)
