package demo.controller;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import javax.validation.Valid;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import demo.entity.Store;
import demo.service.StoreService;

@ExtendWith(MockitoExtension.class)
public class StoreControllerTest {
	
	@InjectMocks
	StoreController storeController;
	
	@Mock
	StoreService service;
	
	@Test
	public void saveStoreTest()
	{
	
		Store store =  new Store();
		store.setStoreId(1);
		when(service.saveStore(store)).thenReturn(1);
		assertNotNull(storeController.saveStore(store));
	}

}
