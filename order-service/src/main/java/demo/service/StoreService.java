package demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import demo.dto.ProductDto;
import demo.entity.Product;
import demo.entity.Store;
import demo.repository.ProductRepository;
import demo.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class StoreService {

	private final StoreRepository storeRepository;

	private final ProductRepository productRepository;

	public Integer saveStore(@Valid Store store) {

		storeRepository.save(store);

		return store.getStoreId();
	}

}
