package demo.service;

import static org.junit.Assert.assertNotNull;

import javax.validation.Valid;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import demo.entity.Store;
import demo.repository.StoreRepository;

@ExtendWith(MockitoExtension.class)
public class StoreServiceTest {

	@InjectMocks
	StoreService storeService;
	
	@Mock
	StoreRepository storeRepository;

	@Test
	public void saveStoreTest() {

		Store store = new Store();
		store.setStoreId(1);
		assertNotNull(storeService.saveStore(store));
	}

}
