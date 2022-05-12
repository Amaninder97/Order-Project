package demo.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import demo.entity.Order;
import demo.repository.OrderRepository;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

	@InjectMocks
	OrderService orderService;

	@Mock
	OrderRepository orderRepository;

	@Test
	public void testGetByOrderId() throws Exception {
		Integer orderId = 1;
		Optional<Order> order = Optional.of(new Order());
		order.get().setState("ALL");
		order.get().setName("Team4");
		Mockito.when(orderRepository.findById(orderId)).thenReturn(order);
		Order ord = orderService.getByOrderId(orderId);
		assertNotNull(ord);
	}

	@Test
	public void testGetByOrderIdwithNull() throws Exception {
		Integer orderId = null;
		Optional<Order> order = Optional.empty();
		Mockito.when(orderRepository.findById(orderId)).thenReturn(order);
		assertThrows(NoSuchElementException.class, () -> {
			Order ord = orderService.getByOrderId(orderId);
			assertNull(ord);
		});
	}

	@Test
	public void testGetByStoreId() throws Exception {
		Integer storeId = 1;
		Order order = new Order();
		order.setState("ALL");
		order.setName("Mobile");
		Mockito.when(orderRepository.findAllByStoreId(storeId)).thenReturn(List.of(order));
		List<Order> ord = orderService.getByStoreId(storeId);
		assertNotNull(ord);
	}

	@Test
	public void testGetByStoreIdWithNull() throws Exception {
		Integer storeId = null;
		Order order = new Order();
		order.setState("ALL");
		order.setName("Mobile");
		Mockito.when(orderRepository.findAllByStoreId(storeId)).thenReturn(List.of(order));
		List<Order> ord = orderService.getByStoreId(storeId);
		assertNotNull(ord);
	}

	@Test
	public void testGetByStoreIdWithTwo() throws Exception {
		Integer storeId = 2;
		List<Order> orderList = new ArrayList<>();
		Mockito.when(orderRepository.findAllByStoreId(storeId)).thenReturn(orderList);
		assertThrows(NoSuchElementException.class, () -> {
			List<Order> ord = orderService.getByStoreId(storeId);
			assertNull(ord);
		});
	}

	@Test
	public void testGetByCustomerId() throws Exception {
		Integer customerId = 1;
		Order order = new Order();
		order.setState("ALL");
		order.setName("Mobile");
		Mockito.when(orderRepository.findAllByCustomerId(customerId)).thenReturn(List.of(order));
		List<Order> ord = orderService.getByCustomerId(customerId);
		assertNotNull(ord);
	}

	@Test
	public void testGetByCustomerIdWithNull() throws Exception {
		Integer customerId = null;
		List<Order> orderList = new ArrayList<>();
		Mockito.when(orderRepository.findAllByCustomerId(customerId)).thenReturn(orderList);
		assertThrows(NoSuchElementException.class, () -> {
			List<Order> ord = orderService.getByCustomerId(customerId);
			assertNull(ord);
		});
	}

	@Test
	public void testSaveAnOrder() throws Exception {
		Order order = new Order();
		order.setName("Mobile");
		order.setState("ALL");
		order.setId(1);
		Mockito.when(orderRepository.save(order)).thenReturn(order);
		Integer orders = orderService.saveAnOrder(order);
		assertNotNull(orders);
		assertEquals(1, 1);
	}

	@Test
	public void testGetByState() throws Exception {
		String state = "PLACED";
		Order order = new Order();
		order.setName("Mobile");
		order.setId(1);
		Mockito.when(orderRepository.findAllByState(state)).thenReturn(List.of(order));
		List<Order> ord = orderService.getByState(state);
		assertNotNull(ord);
	}
	
	@Test
	public void testGetByStatewithALL() throws Exception {
		String state = "ALL";
		Order order = new Order();
		order.setName("Mobile");
		order.setId(1);
		Mockito.when(orderRepository.findAll()).thenReturn(List.of(order));
		List<Order> ord = orderService.getByState(state);
		assertNotNull(ord);
	}
	
	@Test
	public void testGetByStatewithNull() throws Exception {
		String state = " ";
		List<Order> order = new ArrayList<>();
		Mockito.when(orderRepository.findAllByState(state)).thenReturn(order);
		assertThrows(NoSuchElementException.class, () -> {
			List<Order> ord = orderService.getByState(state);
			assertNull(ord);
		});
	}
}
