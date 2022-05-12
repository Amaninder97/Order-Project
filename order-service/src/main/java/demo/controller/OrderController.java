package demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.entity.Order;
import demo.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private OrderService service;

	/*
	 * @PostMapping("/bookOrder") public TransactionResponse bookOrder(@RequestBody
	 * TransactionRequest request) { System.out.println("test"); return
	 * service.saveOrder(request); }
	 */

	@GetMapping("/{id}")
	public Order getByOrderId(@PathVariable("id") Integer orderId) {
		return service.getByOrderId(orderId);
	}

	@GetMapping({ "/store", "/store/{id}" })
	public List<Order> getByStoreId(@PathVariable(name = "id", required = false) Integer storeId) {
		return service.getByStoreId(storeId);
	}

	@PostMapping
	public int saveOrder(@RequestBody Order order) {
		return service.saveAnOrder(order);
	}

	@GetMapping("/customer/{id}")
	public List<Order> getByCustomerId(@PathVariable("id") Integer customerId) {
		return service.getByCustomerId(customerId);
	}

	@GetMapping("/state/{state}")
	public List<Order> filterOrderByState(@PathVariable("state") String state) {
		return service.getByState(state);
	}
}
