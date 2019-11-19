package Restaurant.Restaurant.Restaurant.service;

import Restaurant.Restaurant.Restaurant.Model.Restaurant;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public interface RestaurantService {

    public void addRestaurant(Restaurant restaurant);

    public void addRestaurant(String name, String address);

    public List<Restaurant> getAll();

    public Restaurant getByName(String name);

    public void editRestaurant(Restaurant restaurant);

    public void editRestaurant(Long id, String name,String address);

    public void removeRestaurant(Long id);

    public Optional<Restaurant> getById(Long id);

    public boolean isNameUsed(String name);
}
