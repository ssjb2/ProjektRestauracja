package Restaurant.Restaurant.Restaurant.repository;

import Restaurant.Restaurant.Restaurant.Model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    Restaurant findByName(String name);

}
