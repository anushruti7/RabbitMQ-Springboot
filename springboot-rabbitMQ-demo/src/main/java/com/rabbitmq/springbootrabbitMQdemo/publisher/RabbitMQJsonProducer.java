package com.rabbitmq.springbootrabbitMQdemo.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.rabbitmq.springbootrabbitMQdemo.dto.User;

@Service
public class RabbitMQJsonProducer {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQJsonProducer.class);

	@Value("${rabbitmq.exchange.name}")
	private String exchange;
	@Value("${rabbitmq.json.routingkey.name}")
	private String routingJsonKey;
	
	
	
	
	private RabbitTemplate rabbitTemplate;
	
	public RabbitMQJsonProducer(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate=rabbitTemplate;
	}
	
	public void sendJsonMessage(User user) {
		LOGGER.info(String.format("json message sent %s", user.toString()));
		rabbitTemplate.convertAndSend(exchange, routingJsonKey, user);
	}
	
}
