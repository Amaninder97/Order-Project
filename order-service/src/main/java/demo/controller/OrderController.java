package demo.controller;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import demo.entity.Notification;
import demo.entity.Order;
import demo.service.NotificationService;
import demo.service.OrderService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private OrderService service;

	@Autowired
	private NotificationService notiService;

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
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Order is Created"),
			@ApiResponse(responseCode = "400", description = "Bad Request"),
			@ApiResponse(responseCode = "500", description = "Internal Server Error") })
	@ResponseStatus(code = HttpStatus.CREATED)
	public String saveOrder(@Valid @RequestBody Order order) {

		service.saveAnOrder(order);
		return notiService.sendCancelNotification(new Notification("dv@kv.com", "Order Created Successfully"));
	}

	@GetMapping("/customer/{id}")
	public List<Order> getByCustomerId(@PathVariable("id") Integer customerId) {
		return service.getByCustomerId(customerId);
	}

	@GetMapping("/state/{state}")
	public List<Order> filterOrderByState(@PathVariable("state") String state) {
		return service.getByState(state);
	}

	@GetMapping("list/sort/{sort}/page/{pageno}/order/{order}")
	public List<Order> getPageTwo(@PathVariable("sort") String sort, @PathVariable("pageno") Integer pageno,
			@PathVariable("order") String order) {
		Pageable paging = null;
		if (order.equalsIgnoreCase("ascending")) {
			paging = PageRequest.of((pageno), 5, Sort.by(sort).ascending());
		} else {
			paging = PageRequest.of((pageno), 5, Sort.by(sort).descending());
		}
		List<Order> orderlist = service.sortedOrderList(paging);
		if (orderlist.isEmpty())
			throw new NoSuchElementException("No Result found page");
		return orderlist;
	}
}
