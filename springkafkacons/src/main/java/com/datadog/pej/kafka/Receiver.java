package com.datadog.pej.kafka;


import java.util.UUID;
import java.util.concurrent.CountDownLatch;

import com.datadog.pej.kafka.model.Guide;
import com.datadog.pej.kafka.repository.GuideRepository;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.client.RestTemplate;

public class Receiver {

    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

    private CountDownLatch latch = new CountDownLatch(1);

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    GuideRepository guideRepository;


    public CountDownLatch getLatch() {
        return latch;
    }

    @KafkaListener(topics = "users")
    public void receive(String payload, ConsumerRecord<?, ?> cr) {


        LOGGER.info("received payload='{}'", payload);

        //String exchange = restTemplate.getForObject("https://private-anon-f7a3d7be2f-nexchange2.apiary-mock.com/en/api/v1/rate/rate_id/", String.class);
        //LOGGER.info(exchange);

        String anime = restTemplate.getForObject("http://colormind.io/list/", String.class);
        LOGGER.info(anime);

        String google = restTemplate.getForObject("https://www.google.fr", String.class);
        LOGGER.info(google);

        String title = guideRepository.findAll().get(0).getTitle();
        LOGGER.info("Answer is: " + title);


        latch.countDown();


    }
}
