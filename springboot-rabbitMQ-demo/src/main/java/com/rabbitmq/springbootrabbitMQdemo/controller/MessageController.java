package com.rabbitmq.springbootrabbitMQdemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rabbitmq.springbootrabbitMQdemo.publisher.RabbitMQProducer;

@RestController
@RequestMapping("/api/v1")
public class MessageController {
	
	private RabbitMQProducer producer;
	
	public MessageController(RabbitMQProducer producer) {
		this.producer=producer;
	}
	
	@GetMapping("/publish")
	public ResponseEntity<String> sendMessage(@RequestParam("message") String msg){
		producer.sendMessage(msg);
		return ResponseEntity.ok("message sent to rabbit mq");
	}

	
	
}
