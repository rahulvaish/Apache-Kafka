# Kafka Cluster:
<img width="564" alt="image" src="https://user-images.githubusercontent.com/689226/161364491-bf3d6376-ac81-4bd5-b101-5ea91d5b0400.png">
A Kafka cluster is a distributed architecture - However, it does not follows master - slave architecture. Instesd a Kafka cluster is managed by zookeeper. 

![image](https://user-images.githubusercontent.com/689226/159184196-4fcff60b-12d5-497e-9158-b922af3e864f.png)
*Example of 4 Brokers Cluster [Linux Doc](https://github.com/rahulvaish/Apache-Kafka/blob/KafkaEnvironment/InstallingKafkaOnUbuntu.MD):*
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


### 5 Brokers | 2 Racks  

<img width="1034" alt="image" src="https://user-images.githubusercontent.com/689226/161410342-57e1078b-90f2-404d-bfba-62a50b8cbba7.png">

### 1 Topics | 10 Partitions | 3 Replication
![image](https://user-images.githubusercontent.com/689226/161410999-9378f1bc-2fff-43ec-be82-fa00cfb65348.png)

### Broker selection sequence
![image](https://user-images.githubusercontent.com/689226/161410894-a98e48bf-ace5-4bff-a3ee-01b88f7e805b.png)

### Partion & Replication Distribution
<img width="999" alt="image" src="https://user-images.githubusercontent.com/689226/161410679-11d673a7-98ec-4c4d-b3a0-0fdc4bc3e56f.png">

### If Rack#1 goes down, we still have data copis of every partition in Rack#2
<img width="986" alt="image" src="https://user-images.githubusercontent.com/689226/161411239-79570e43-5767-41ad-a11a-674e211aa70d.png">

*Example:*
<img width="1010" alt="image" src="https://user-images.githubusercontent.com/689226/159184957-8078576b-ab24-4022-b56e-ba0e421a47ec.png">

- In the diagram above we saw Leaders and Followers. The job of the follower partitions is to copy messages from Leader and keep themselves as up-to-date. This happens as infinite loop between followers and leaders (below). When the leader fails/dies, any one follower replaces it (so keeping in sync with data is important).
![image](https://user-images.githubusercontent.com/689226/161412599-97e3a97f-22c9-4823-a357-d53d4f427e80.png)

- Leaders aslo maintains the list of underlying followers (as ISR List - in sync replicas), and persists in zookeeper. 
- The ISR List is dynamic. Below logic explains the dynamics:
<img width="1045" alt="image" src="https://user-images.githubusercontent.com/689226/161412634-043fe9ae-b913-4606-9609-2ba1a20e38fa.png">
*'Not to Far' is defined as time takes between follower asking for data + receiving + persisting + re-asking. Default value of NTF < 10 seconds.*


<hr>

# Producer

- Producer connects with any broker to get the metadata. The metadata consists of all the leaders.
- Kakfa uses the list to write/prodduce data on the leader.
- The data appends on partion as below:
![image](https://user-images.githubusercontent.com/689226/159184849-0fb02300-d41e-49dd-8773-f8997696fae7.png)
```
FunExperimentExample: Add multiple messages with key as "abc", let say the resultant # will point to Partition2.
Add n data to a topic, and on search you will find all n data items will be landing on Partition2.
```

### Internal working of Producer

<img width="929" alt="image" src="https://user-images.githubusercontent.com/689226/161400420-0232c90e-032c-4551-b36d-687d14bca658.png">

- Only Topic and Message Value are mandatory parameters of Producer Record object
- Key:If you provide key, the hash of the key is calculated and according to the result the the partition is chosen for data to reside.When you don't provide the key the data goes in Round Robin fashion amongst the various partitions
- Timestamp: For create time (time when msg is produced) value is 0. For Log append time (time when message is received) the value is 1.
- Partition: You can specify manually the partion you want to send data to (not optimal approach)
- Serializer Serializes the Key & Message Value
- Partitioner: Kafka Default partitioner works by checking the 'Partition' value of Producer Record.
- Buffers offer async data transfer + network optimisation

- 

<hr>


![image](https://user-images.githubusercontent.com/689226/159184869-2d70a9d0-e474-428c-98b6-4a1a7b0e2e64.png)

![image](https://user-images.githubusercontent.com/689226/159184873-b2a09ce6-2b38-41a6-8f55-d58f00146f45.png)
