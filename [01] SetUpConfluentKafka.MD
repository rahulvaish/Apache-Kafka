### Confluent Kafka

##### STEP#1: Install Confluent Kafka
```
curl -sL --http1.1 https://cnfl.io/cli | sh -s -- latest
export PATH=$(pwd)/bin:$PATH
confluent version
```

##### STEP#2: Login into confluent Kafka

```
confluent login --save
confluent environment list
confluent environment use env-8nd80
confluent kafka cluster list
confluent kafka cluster use lkc-doo321
```
