package com.lamina.user.config;

import com.lamina.user.controller.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class KafkaSender {

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaSender.class);

	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;

	@Value("${kafka.topic.name}")
	private String topicName;

	public void sendData(User student) {
		// TODO Auto-generated method stub
		Map<String, Object> headers = new HashMap<>();
		headers.put(KafkaHeaders.TOPIC, topicName);
		kafkaTemplate.send(new GenericMessage<User>(student, headers));
		// use the below to send String values through kafka
		 kafkaTemplate.send(topicName, student);
		LOGGER.info("Data - " + student.toString() + " sent to Kafka Topic - " + topicName);
	}
}
