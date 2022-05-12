package demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "CUSTOMER_TB")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

	@Id
	private Integer customerId;
	private String customerName;
}
