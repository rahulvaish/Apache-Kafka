### Internals of Kafka Producer:
<img width="916" alt="image" src="https://user-images.githubusercontent.com/689226/161400408-4e17720c-6787-4135-bcba-101f47d13d19.png">

- Only Topic and Message Value are mandatory parameters of Producer Record object
- Key:If you provide key, the hash of the key is calculated and according to the result the the partition is chosen for data to reside.When you don't provide the key the data goes in Round Robin fashion amongst the various partitions
- Timestamp: Deafault timestamp is 0 whihc is create time.
- Partition: You can specify manually the partion you want to send data to (not optimal approach)
- Serializer Serializes the Key & Message Value
- Partitioner: Kafka Default partitioner works by checking the 'Partition' value of Producer Record.
- Buffers offer async data transfer + network optimisation

<img width="929" alt="image" src="https://user-images.githubusercontent.com/689226/161400420-0232c90e-032c-4551-b36d-687d14bca658.png">

