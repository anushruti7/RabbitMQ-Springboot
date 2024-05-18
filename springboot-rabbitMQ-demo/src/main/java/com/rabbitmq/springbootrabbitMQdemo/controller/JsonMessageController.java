package com.rabbitmq.springbootrabbitMQdemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rabbitmq.springbootrabbitMQdemo.dto.User;
import com.rabbitmq.springbootrabbitMQdemo.publisher.RabbitMQJsonProducer;

@RestController
@RequestMapping("/api/v2")
public class JsonMessageController {

	private RabbitMQJsonProducer jsonProducer;
	
	public JsonMessageController(RabbitMQJsonProducer jsonProducer) {
		this.jsonProducer=jsonProducer;
	}
	
	@PostMapping("/publish")
	public ResponseEntity<String> sendJsonMessage(@RequestBody User user){
		jsonProducer.sendJsonMessage(user);
		return ResponseEntity.ok("json message sent to rabbit mq");
	}
	
}
