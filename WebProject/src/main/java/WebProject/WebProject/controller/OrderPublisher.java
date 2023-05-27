package WebProject.WebProject.controller;

import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import WebProject.WebProject.config.MessagingConfig;
import WebProject.WebProject.entity.Order;
import WebProject.WebProject.entity.OrderStatus;

@RestController
@RequestMapping("/order")
public class OrderPublisher {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@PostMapping("/{restaurantName}")
	public String bookOrder(@RequestBody Order order,@PathVariable String restaurantName) {
		order.setStatus(OrderStatus.PROCESSING);
		rabbitTemplate.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.BINDING, order);
		return "Sucessed !";
	}
}

