### Confluent Kafka Basics

##### Topics & Partitioning

- A Topic is a *path/platform* which is subscribed by Producer and Subscriber.
- Producer publishes contents on the topic and Consumer fetches the same from it.
- A Topic has *n* partitionings, when Producer publishes data on the topic, the data goes and resides in one of the partition.

- **Case1**: When you associate a Key along with Value -> The hash of the key is calculated and according to the result the the partition is chosen for data to reside.

- **Case2**: When you do not associate a Key along with Value -> The data goes in Round Robin fashion amongst the various partitions. 
```
FunExperimentExample: Add multiple messages with key as "abc", let say the resultant # will point to Partition2.
Add n data to a topic, and on search you will find all n data items will be landing on Partition2.
```
- Everytime the data goes in a partition it is 'appended' after previous. The index is referred as *offset*.

![image](https://user-images.githubusercontent.com/689226/159131764-a87f1179-aa7d-4b65-863d-067171eb1359.png)


```
confluent kafka topic list 
confluent kafka topic describe topicA
```

<img width="944" alt="image" src="https://user-images.githubusercontent.com/689226/159127406-48968fde-fb93-4ef5-a09e-6ae6f37cabc2.png">
<img width="1406" alt="image" src="https://user-images.githubusercontent.com/689226/159129504-6fbf0714-4657-4e01-bbbd-0fff38f55b52.png">

##### Create Topic:
```
confluent kafka topic create --partitions 4 topicB
```
<img width="1436" alt="image" src="https://user-images.githubusercontent.com/689226/159129674-b16f9b44-2d2f-4ab2-b157-0f463dd405a5.png">

##### Test new Topic: Produce a message on topicB:
<img width="1396" alt="image" src="https://user-images.githubusercontent.com/689226/159129910-bfeab6f2-2575-4fef-a19e-aca64c3e02b3.png">

##### Checking on consumer end which has subscribed to topicB:
<img width="1109" alt="image" src="https://user-images.githubusercontent.com/689226/159129939-371afd96-d296-4d47-aef0-23aeeb10d8a4.png">

