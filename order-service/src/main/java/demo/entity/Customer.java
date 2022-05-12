package demo.entity;

import javax.persistence.Entity;
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

	private int customerId;
	private int customerName;
	
}
