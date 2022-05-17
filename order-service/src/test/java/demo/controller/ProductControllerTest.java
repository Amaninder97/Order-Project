package demo.controller;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import javax.validation.Valid;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import demo.dto.ProductDto;
import demo.entity.Product;
import demo.service.ProductService;

@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {
	
	@InjectMocks
	ProductController productController;
	
	@Mock
	ProductService service;
	
	@Test
	public void saveProductTest()
	{
		
		Product product = new Product();
		product.setProductId(1);
		when(service.saveProduct(product)).thenReturn(1);
		assertNotNull(productController.saveProduct(product));
	}
	
	@Test
	public void getProductsTest()
	{
	
		Product product = new Product();
		product.setProductId(1);
		ProductDto prodDto = new ProductDto();
		prodDto.setProduct(product);
		when(service.getProducts(1)).thenReturn(prodDto);
		assertNotNull(productController.getProducts(1));
	}

}
