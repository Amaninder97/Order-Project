package demo.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "PRODUCT_TB")
@NoArgsConstructor
@AllArgsConstructor
public class Product {

	@Id
	@NotNull(message = "Product id cannot be null")
	@Min(value = 1, message = "Product id cannot be Negative")
	private int productId;
	
	@NotBlank(message = "order state cannot be blank")
	private String productName;
	
	@NotNull(message = "Store id cannot be null")
	private Integer storeId;

}
