package demo.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import demo.common.Payment;
import demo.common.TransactionRequest;
import demo.common.TransactionResponse;
import demo.common.*;
import demo.entity.Order;
import demo.repository.OrderRepository;

@Service
public class OrderService 
{
	@Autowired
	private OrderRepository repository;
	
	@Autowired
	private RestTemplate template;
	
	public TransactionResponse saveOrder(TransactionRequest request)
	{
		String response = "";
		Order order = request.getOrder();
		Payment payment = request.getPayment();
		payment.setOrderId(order.getId());
		payment.setAmount(order.getPrice());
		
		Payment paymentResponse = template.postForObject("http://PAYMENT-SERVICE/payment/doPayment",payment,Payment.class);
		
		response = paymentResponse.getPaymentStatus().equals("success")?"payment processing successful":"there is a failure";
		
		repository.save(order);
		
//		return new TransactionResponse(order, paymentResponse.getAmount(), paymentResponse.getTransactionId(), response);
		return new TransactionResponse();	
		}
	
	public Order getByOrderId(int orderId) {
		Optional<Order> order = repository.findById(orderId);
		if(order.isPresent()) 
			return order.get();
		else
			throw new NoSuchElementException(orderId + " is not present in the database");
		
	}
	
	public int saveAnOrder(Order order) {
		repository.save(order);
		return order.getId();
	}

	public List<Order> getByStoreId(int storeId) {
		List<Order> order = repository.findAllByStoreId(storeId);
		if(!order.isEmpty()) 
			return order;
		else
			throw new NoSuchElementException(storeId + " is not present in the database");
	}
}
