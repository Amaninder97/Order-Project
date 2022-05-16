package demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ORDER_TB")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotNull
	private Integer storeId;
	
	
	@NotNull
	@Min(value = 1, message = "CustomerId cannot be Negative")
	private Integer customerId;
	
	private Integer productId;
	
	@NotBlank(message = "name cannot be blank")
	private String name;
	
	private String state;
	
	@NotNull
	@Min(value = 1, message = "qty cannot be Negative")
	private Integer qty;
	
	@NotNull
	@Min(value = 1, message = "price cannot be Negative")
	private Double price;

}
