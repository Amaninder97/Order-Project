package demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.common.*;
import demo.common.TransactionRequest;
import demo.entity.Order;
import demo.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController 
{
	@Autowired
	private OrderService service;
	
	@PostMapping("/bookOrder")
	public TransactionResponse bookOrder(@RequestBody TransactionRequest request)
	{
		System.out.println("test");
		return service.saveOrder(request);
	}
	
	@GetMapping("/{id}")
	public Order getByOrderId(@PathVariable("id") int orderId) {
		return service.getByOrderId(orderId);
	}
	
	@GetMapping("/store/{id}")
	public List<Order> getByStoreId(@PathVariable("id") int storeId) {
		return service.getByStoreId(storeId);
	}
	
	@PostMapping
	public int saveOrder(@RequestBody Order order) {
		return service.saveAnOrder(order);
	}
}
