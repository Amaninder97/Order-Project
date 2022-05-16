package demo.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import demo.entity.Store;

import demo.service.StoreService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/store")
@RequiredArgsConstructor
public class StoreController {

	private final StoreService service;

	@PostMapping
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Product is Created"),
			@ApiResponse(responseCode = "400", description = "Bad Request"),
			@ApiResponse(responseCode = "500", description = "Internal Server Error") })
	@ResponseStatus(code = HttpStatus.CREATED)
	public Integer saveStore(@Valid @RequestBody Store store) {
		return service.saveStore(store);
	}

}
