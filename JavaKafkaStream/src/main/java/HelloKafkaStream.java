
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.KStream;

import java.util.Properties;

public class HelloKafkaStream {

	public static void main(String[] args) {
		
		String sourceTopic = "topicA";
		String destinationTopic = "topicB";
        String brokers = "localhost:9092";
	    String IntegerSerializer = "org.apache.kafka.common.serialization.IntegerSerializer";
        String StringSerializer = "org.apache.kafka.common.serialization.StringSerializer";

        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "java-kafka-streams");
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, brokers);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer);
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.Integer().getClass());
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());

        StreamsBuilder streamsBuilder = new StreamsBuilder();
        KStream<Integer, String> kStream = streamsBuilder.stream(sourceTopic);
        //kStream.foreach((k, v) -> System.out.println("Key= " + k + " Value= " + v));
        kStream.filter((k,v)->v.contains("a")).to(destinationTopic);;
       

        Topology topology = streamsBuilder.build();
        KafkaStreams streams = new KafkaStreams(topology, props);
        System.out.println("Starting stream.");
        streams.start();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
        	System.out.println("Shutting down stream");
            streams.close();
        }));

	}

}
