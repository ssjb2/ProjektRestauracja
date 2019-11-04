package Restaurant.Restaurant.Order.repository;

import Restaurant.Restaurant.Order.Model.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderModel, Long> {

}
