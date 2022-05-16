package demo.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import demo.dto.ProductDto;
import demo.entity.Product;
import demo.service.ProductService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
	
	private final ProductService service;
	
	@PostMapping
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Product is Created"),
			@ApiResponse(responseCode = "400", description = "Bad Request"),
			@ApiResponse(responseCode = "500", description = "Internal Server Error") })
	@ResponseStatus(code = HttpStatus.CREATED)
	public Integer saveProduct(@Valid @RequestBody Product product) {
		return service.saveProduct(product);
	}
	
	@GetMapping("/{productId}")
	public ProductDto getProducts(@PathVariable("productId") Integer productId)
	{
		return service.getProducts(productId);
	}

}
