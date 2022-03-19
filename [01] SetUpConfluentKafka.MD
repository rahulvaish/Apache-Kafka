### Confluent Kafka

##### STEP#1: Install Confluent Kafka
```
curl -sL --http1.1 https://cnfl.io/cli | sh -s -- latest
export PATH=$(pwd)/bin:$PATH
confluent version
```

##### STEP#2: Login into Confluent Kafka

```
confluent login --save
confluent environment list
confluent environment use env-8nd80
confluent kafka cluster list
confluent kafka cluster use lkc-doo321
```
<img width="1256" alt="image" src="https://user-images.githubusercontent.com/689226/159107853-be9ec0b4-3876-491a-9c01-414156367d80.png">


##### STEP#3: Setting Keys
```
confluent api-key create --resource lkc-doo321
confluent api-key use MT6YSP56J7UBL7XU --resource lkc-doo321
```
<img width="1184" alt="image" src="https://user-images.githubusercontent.com/689226/159108162-fb969d83-e9bc-41ff-a66c-56a09073f004.png">

##### STEP#4: Producer & Consumer

Producer:
```
confluent kafka topic produce topicA --parse-key
```
Consumer:
```
confluent kafka topic consume --from-beginning topicA
```

<img width="1354" alt="image" src="https://user-images.githubusercontent.com/689226/159109143-90be81d8-ffe2-4a64-8719-9f62208701b8.png">
