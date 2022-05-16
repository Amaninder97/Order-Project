package demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

	List<Order> findAllByStoreId(Integer storeId);

	List<Order> findAllByCustomerId(Integer customerId);

	List<Order> findAllByState(String state);

	Order findByProductId(Integer productId);
}
