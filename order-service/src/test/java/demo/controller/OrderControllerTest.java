package demo.controller;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import demo.OrderServiceApplication;
import demo.entity.Order;
import demo.service.NotificationService;
import demo.service.OrderService;

@ExtendWith(MockitoExtension.class)
public class OrderControllerTest {

	@InjectMocks
	OrderController orderController;

	@Mock
	OrderService orderService;
	
	@Mock
	NotificationService notiService; 
	
	@Test
	public void testGetByOrderId() throws Exception {
		Integer orderId = 1;
		Order order = new Order();
		order.setCustomerId(1);
		order.setName("Team4");
		Mockito.when(orderService.getByOrderId(orderId)).thenReturn(order);
		Order ord = orderController.getByOrderId(orderId);
		String[] args = {"Java"};
		
		assertNotNull(ord);
	}
	
	@Test
	public void testGetByStoreId() throws Exception {
		Integer storeId = 1;
		Order order = new Order();
		order.setCustomerId(1);
		order.setName("Team4");
		Mockito.when(orderService.getByStoreId(storeId)).thenReturn(List.of(order));
		List<Order> ord = orderController.getByStoreId(storeId);
		assertNotNull(ord);
	}
	
	@Test
	public void testGetByCustomerId() throws Exception {
		Integer customerId = 1;
		Order order = new Order();
		order.setName("Team4");
		Mockito.when(orderService.getByCustomerId(customerId)).thenReturn(List.of(order));
		List<Order> ord = orderController.getByCustomerId(customerId);
		assertNotNull(ord);
	}
	
	@Test
	public void testFilterOrderByState() throws Exception {
		String state = "ALL";
		Order order = new Order();
		order.setName("Team4");
		Mockito.when(orderService.getByState(state)).thenReturn(List.of(order));
		List<Order> ord = orderController.filterOrderByState(state);
		assertNotNull(ord);
	}
	
	@Test
	public void testSaveOrder() throws Exception {
		Order order = new Order();
		order.setCustomerId(1);
		order.setName("Team4");
		order.setStoreId(5);
		order.setState("PLACED");
		Mockito.when(orderService.saveAnOrder(order)).thenReturn(1);
		when(notiService.sendCreateNotification(Mockito.any())).thenReturn("Success");
		orderController.saveOrder(order);
		assertNotNull(order);
	}
	
	@Test
	public void testCancelOrder() throws Exception {
		Order order = new Order();
		order.setCustomerId(1);
		order.setName("Team4");
		order.setStoreId(5);
		order.setState("PLACED");
		
		when(notiService.sendCancelNotification(Mockito.any())).thenReturn("Success");
		orderController.cancelOrder(1);
		assertNotNull(order);
	}
	
	@Test
	public void getPageTwoTest()
	{
		assertThrows(NoSuchElementException.class, () -> {
			orderController.getPageTwo("name", 0, "ascending");
		});
		
		
	}
	
	
	
	@Test
	public void getPageTwoTestDesc()
	{
            Order order = new Order();
			when(orderService.sortedOrderList(Mockito.any())).thenReturn(List.of(order));
			orderController.getPageTwo("name", 0, "descending");
		
	}

}
