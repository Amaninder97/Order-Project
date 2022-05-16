package demo.exceptionHandler;

import java.security.Principal;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.context.request.WebRequest;

import demo.exceptionhandler.CustomExceptionhandler;

@ExtendWith(MockitoExtension.class)
public class CustomExceptionhandlerTest {
	
	@InjectMocks
	CustomExceptionhandler customExceptionhandler;
	
	@Test
	public void handleNoSuchElementExceptionTest()
	{
		NoSuchElementException ex = new NoSuchElementException();
		
		customExceptionhandler.handleNoSuchElementException(ex);
	}

}
