package Restaurant.Restaurant.Restaurant.service;

import Restaurant.Restaurant.Restaurant.Model.Restaurant;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public interface RestaurantService {

    public void addRestaurant(String name, String address);

    Restaurant addRestaurant(Restaurant restaurant);

    public List<Restaurant> getAll();

    public void removeRestaurant(Long id);

    public void editRestaurant(Long id, String name,String address);

    public Optional<Restaurant> getById(Long id);

    public boolean isNameUsed(String name);
}
