### Confluent Kafka Basics

##### Listing Topic:

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

