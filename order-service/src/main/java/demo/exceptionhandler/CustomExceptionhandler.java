package demo.exceptionhandler;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import demo.entity.ExceptionResponse;


@RestControllerAdvice
public class CustomExceptionhandler extends ResponseEntityExceptionHandler {

	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<ExceptionResponse> handleNoSuchElementException(NoSuchElementException ex) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDateTime.now(), "No Result found page","No data found");
		logger.error("No Result found page: " + ex.getMessage());
		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
	
	
}