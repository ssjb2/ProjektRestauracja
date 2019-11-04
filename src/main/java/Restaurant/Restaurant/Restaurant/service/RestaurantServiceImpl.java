package Restaurant.Restaurant.Restaurant.service;

import Restaurant.Restaurant.Restaurant.Model.Restaurant;
import Restaurant.Restaurant.Restaurant.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

    @Override
    public void addRestaurant(Restaurant restaurant) {
        restaurantRepository.save(restaurant);

    }

    @Override
    public List<Restaurant> getAll() {
        return  restaurantRepository.findAll();
    }

    @Override
    public Restaurant getByname(String name) {
        return  restaurantRepository.findByName(name);
    }

}
