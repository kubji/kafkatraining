/*
package com.kubji.kafkatraining.serialization.avro;



import com.kubji.avro.PageView;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Date;
import java.util.Properties;
import java.util.Random;

*/
/**
 * Created by kafka on 16/1/19.
 *//*

public class AvroPageViewProducerV1 implements Runnable{

    private final KafkaProducer<String, PageView> producer;
    private final String topic;

    public AvroPageViewProducerV1(String brokers, String topic, String schemaUrl) {
        Properties prop = createProducerConfig(brokers, schemaUrl);
        this.producer = new KafkaProducer<String, PageView>(prop);
        this.topic = topic;
    }

    private static Properties createProducerConfig(String brokers, String schemaRegistryUrl) {
        Properties props = new Properties();
        props.put("bootstrap.servers", brokers);
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "io.confluent.kafka.serializers.KafkaAvroSerializer");
        props.put("schema.registry.url", schemaRegistryUrl);
        props.put("auto.register.schemas",false);

        return props;
    }



    @Override
    public void run() {
        System.out.println("Produces Started");
        int i = 0;
        Random rnd = new Random();

        try {
        while (true) {
            final PageView pageView = new PageView();
            pageView.setPage("kubji/page" + (rnd.nextInt(100) + 1));
            String ip = "192.168.2." + rnd.nextInt(255);
            pageView.setIp(ip);
            long runtime = new Date().getTime();
            pageView.setTime(runtime);

            producer.send(new ProducerRecord<String, PageView>(topic, pageView), new Callback() {
                public void onCompletion(RecordMetadata metadata, Exception e) {
                    if (e != null) {
                        e.printStackTrace();
                    }
                    System.out.println("Sent:" + pageView + ", Topic: " + topic  + " Partition: " + metadata.partition() + ", Offset: "
                            + metadata.offset());
                }
            });
            i++;
            Thread.sleep(1000);
            }
        }
           catch (InterruptedException ie) {
               producer.close();

            }
        }


    public static void main(String[] args) {

        if (args.length != 2) {
            System.out.println("Please provide command line arguments: topic & SchemaRegistryUrl");
            System.exit(-1);
        }
        String topic = args[0];
        String schemaRegistryUrl = args[1];
        AvroPageViewProducerV1 producerThread = new AvroPageViewProducerV1("localhost:9092", topic,schemaRegistryUrl);
        Thread t1 = new Thread(producerThread);
        t1.start();
    }

}
*/
