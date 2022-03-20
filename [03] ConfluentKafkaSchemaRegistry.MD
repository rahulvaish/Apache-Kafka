### Confluent Kafka Schema Registry


<img width="1002" alt="image" src="https://user-images.githubusercontent.com/689226/159186619-3518b1dc-77ba-4dfa-95f2-62471d4945de.png">

##### What if the Producer sends bad data or fields gets renamed  - The consumer breaks ! To solve this porblem we need a schems and make use of Schema Registry. SR is a seperate component and Producer/Consumer needs to talk to it. SR should be able to identify the bad data. 

![image](https://user-images.githubusercontent.com/689226/159186577-083114f1-d1a2-44c7-9b43-ffdd2c610c67.png)

<hr>

#### STEP#1:  SetUp default Schema Registry 
<img width="556" alt="image" src="https://user-images.githubusercontent.com/689226/159187036-29465e82-d9e9-407b-b77b-7e56de9dbe80.png">
<img width="1063" alt="image" src="https://user-images.githubusercontent.com/689226/159186999-8ae50f4d-d9e7-4c7c-a8a4-008059c37347.png">
<img width="1544" alt="image" src="https://user-images.githubusercontent.com/689226/159187053-c6e96a37-23a1-4a48-adf6-e40a19c04f41.png">

<hr>

#### STEP#2:  Create a Connector & Topic
<img width="1302" alt="image" src="https://user-images.githubusercontent.com/689226/159187118-5318a896-99d3-42f9-803d-57516afd0355.png">

<img width="1345" alt="image" src="https://user-images.githubusercontent.com/689226/159187238-bff8c557-33d9-450c-adc7-6f110b8509ab.png">

<img width="1245" alt="image" src="https://user-images.githubusercontent.com/689226/159187279-85a6b01e-5cc0-4647-b281-e303dbf3c76d.png">

<img width="1223" alt="image" src="https://user-images.githubusercontent.com/689226/159187294-22707bee-a325-48f9-92e6-5b3ff5e808b9.png">

<img width="760" alt="image" src="https://user-images.githubusercontent.com/689226/159187334-ec4160f4-fd72-4ee9-8d6f-351e178094ca.png">

<img width="768" alt="image" src="https://user-images.githubusercontent.com/689226/159187346-0f0b5535-e73f-44cf-b227-2f1ba26a10ef.png">

<img width="1415" alt="image" src="https://user-images.githubusercontent.com/689226/159187742-530b0101-68e3-49d1-b563-960970301c0e.png">

#### STEP#3:  Check Schema Registry

<img width="1339" alt="image" src="https://user-images.githubusercontent.com/689226/159188062-4b1f7575-2f06-482d-9d84-6aada53fb66b.png">

<img width="1252" alt="image" src="https://user-images.githubusercontent.com/689226/159188180-25764a95-6ed9-400e-9146-9a2ace4e10ae.png">

#### STEP#4:  Create API Key on Schema Registry
<img width="1356" alt="image" src="https://user-images.githubusercontent.com/689226/159188990-3162dbcc-18bb-4ff4-b5ab-b0ed19358127.png">

#### STEP#5:  Check Data on topic
```
confluent kafka topic consume --value-format avro --sr-api-key KHUOEQ42ADUDVJKM --sr-api-secret F0OTeaz6usEGtqA47Mk54pwIjWgryBq+RoITtfVg7xTBpm+ximHXSVdUypdGo+7G  topicCustomer
```
<img width="1724" alt="image" src="https://user-images.githubusercontent.com/689226/159189527-bfc0a9ff-2e0f-4dbf-bf7b-6d2f93c5f7c7.png">

#### Do Not use the traditional way of consuming:
<img width="1202" alt="image" src="https://user-images.githubusercontent.com/689226/159189127-4d9e51c2-33f4-459b-8cf0-82ae2aef63c1.png">

<img width="1490" alt="image" src="https://user-images.githubusercontent.com/689226/159189189-7d151669-606c-49de-80d6-c44b9aa86bca.png">

<img width="1303" alt="image" src="https://user-images.githubusercontent.com/689226/159189272-bb7cb2c4-8f62-49bd-87be-9f55b52bc169.png">


