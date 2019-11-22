package Restaurant.Restaurant.Cart.Repository;

import Restaurant.Restaurant.Cart.Model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {



}
