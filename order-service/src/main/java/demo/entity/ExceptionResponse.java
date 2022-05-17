package demo.entity;

import java.time.LocalDateTime;

import demo.dto.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponse {

   

    private LocalDateTime timestamp;

    private String message;

    private String details;

   
}