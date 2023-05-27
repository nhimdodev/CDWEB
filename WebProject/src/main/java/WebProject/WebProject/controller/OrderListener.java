package WebProject.WebProject.controller;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import WebProject.WebProject.config.MessagingConfig;
import WebProject.WebProject.entity.Order;

@Component
public class OrderListener {

	@RabbitListener(queues = MessagingConfig.QUEUE)
	public void consumeOrderFromQueue(Order order) {
		System.err.println("Messasge recieved from queue: " + order);
	}
	
	@RabbitListener(queues = MessagingConfig.QUEUE)
	public void consumeOrderFromQueue1(Order order) {
		System.err.println("Messasge recieved from queue: " + order);
	}
	
	@RabbitListener(queues = MessagingConfig.QUEUE)
	public void consumeOrderFromQueue2(Order order) {
		System.err.println("Messasge recieved from queue: " + order);
	}
	
	
	
}
