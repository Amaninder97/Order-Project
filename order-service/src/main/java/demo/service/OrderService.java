package demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import demo.entity.Order;
import demo.repository.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository repository;

	@Autowired
	private RestTemplate template;

	@Value("${order.defaultStoreId}")
	private Integer defaultStoreId;
	
	@Value("${order.inventoryUrl}")
	private String inventoryUrl;

	/*
	 * public TransactionResponse saveOrder(TransactionRequest request) { String
	 * response = ""; Order order = request.getOrder(); Payment payment =
	 * request.getPayment(); payment.setOrderId(order.getId());
	 * payment.setAmount(order.getPrice());
	 * 
	 * Payment paymentResponse =
	 * template.postForObject("http://PAYMENT-SERVICE/payment/doPayment", payment,
	 * Payment.class);
	 * 
	 * response = paymentResponse.getPaymentStatus().equals("success") ?
	 * "payment processing successful" : "there is a failure";
	 * 
	 * repository.save(order);
	 * 
	 * // return new TransactionResponse(order, paymentResponse.getAmount(),
	 * paymentResponse.getTransactionId(), response); return new
	 * TransactionResponse(); }
	 */

	public Order getByOrderId(Integer orderId) {
		Optional<Order> order = repository.findById(orderId);
		if (order.isPresent())
			return order.get();
		else
			throw new NoSuchElementException(orderId + " is not present in the database");
	}

	public int saveAnOrder(Order order) {
		repository.save(order);
		return order.getId();
	}

	public List<Order> getByStoreId(Integer storeId) {

		List<Order> order = repository.findAllByStoreId(null == storeId ? defaultStoreId : storeId);
		if (!order.isEmpty())
			return order;
		else
			throw new NoSuchElementException(storeId + " is not present in the database");
	}

	public List<Order> getByCustomerId(Integer customerId) {
		List<Order> order = repository.findAllByCustomerId(customerId);
		if (!order.isEmpty())
			return order;
		else
			throw new NoSuchElementException(customerId + " is not present in the database");
	}

	public List<Order> getByState(String state) {
		if ("ALL".equals(state)) {
			List<Order> order = repository.findAll();
			return order;
		}
		List<Order> order = repository.findAllByState(state);
		if (!order.isEmpty())
			return order;
		else
			throw new NoSuchElementException("No Orders with " + state + "State");
	}

	public List<Order> sortedOrderList(Pageable paging) {
		Page<Order> page = repository.findAll(paging);
		return page.getContent();
	}

	public void cancelOrder(Integer orderId) {

		repository.deleteById(orderId);
		
//	    Map<String,Integer> queryParam = new HashMap<>();
//	    queryParam.put("orderId", orderId);
//	    
//	    String response = template.getForObject(inventoryUrl, String.class, queryParam);
//	    System.out.println("Response: " + response);
		
	}
}
