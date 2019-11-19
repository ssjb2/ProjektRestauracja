package Restaurant.Restaurant.Dish.repository;

import Restaurant.Restaurant.Dish.Model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DishRepository extends JpaRepository<Dish, Long> {

    Optional<Dish> findByName(String name);
}
