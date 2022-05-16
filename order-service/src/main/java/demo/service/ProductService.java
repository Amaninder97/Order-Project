package demo.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import demo.dto.ProductDto;
import demo.entity.Order;
import demo.entity.Product;
import demo.entity.Store;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import demo.repository.OrderRepository;
import demo.repository.ProductRepository;
import demo.repository.StoreRepository;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {
	
	private final ProductRepository productRepository;
	
	private final OrderRepository orderRepository;
	
    private final StoreRepository storeRepository;
	
	private final OrderService orderService;
	
	public Integer saveProduct(@Valid Product product) {

		productRepository.save(product);
		return product.getProductId();
	}

	public ProductDto getProducts(Integer productId) {
		
		Product product = productRepository.findById(productId).get();
		
		Order order = orderRepository.findByProductId(productId);
		
		Store store = storeRepository.findById(product.getStoreId()).get();
		
		ProductDto dto = ProductDto.builder().product(product).order(order).store(store).build();
		
		return dto;
	}

}
