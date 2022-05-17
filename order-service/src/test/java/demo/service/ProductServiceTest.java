package demo.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Optional;

import javax.validation.Valid;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import demo.entity.Order;
import demo.entity.Product;
import demo.entity.Store;
import demo.repository.OrderRepository;
import demo.repository.ProductRepository;
import demo.repository.StoreRepository;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
	
	@InjectMocks
	ProductService productService;
	
	@Mock
    ProductRepository productRepository;
	
	@Mock
	OrderRepository orderRepository;
	
	@Mock
    StoreRepository storeRepository;
	
	@Test
	public void saveProductTest()
	{
		
		Product product = new Product();
		assertNotNull(productService.saveProduct(product));
	}
	
	@Test
	public void getProductsTest()
	{
		
		Optional<Product> product = Optional.of(new Product());
		product.get().setStoreId(1);
		Order order = new Order();
		Optional<Store> store = Optional.of(new Store());
		when(storeRepository.findById(product.get().getStoreId())).thenReturn(store);
		when(orderRepository.findByProductId(1)).thenReturn(order);
		when(productRepository.findById(1)).thenReturn(product);
		assertNotNull(productService.getProducts(1));
	}

}
