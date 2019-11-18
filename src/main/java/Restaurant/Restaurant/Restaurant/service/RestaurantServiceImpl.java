package Restaurant.Restaurant.Restaurant.service;

import Restaurant.Restaurant.Restaurant.Model.Restaurant;
import Restaurant.Restaurant.Restaurant.repository.RestaurantRepository;
import Restaurant.Restaurant.User.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

    @Override
    public void addRestaurant(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
    }

    @Override
    public void addRestaurant(String name, String address) {
        Restaurant restaurant = new Restaurant();
        restaurant.setName(name);
        restaurant.setAddress(address);
        restaurantRepository.save(restaurant);
    }

    @Override
    public List<Restaurant> getAll() {
        return restaurantRepository.findAll();
    }

    @Override
    public Restaurant getByName(String name) {

        Optional<Restaurant> tempOptRestaurant = restaurantRepository.findByName(name);
        if(tempOptRestaurant.isPresent()){
            return tempOptRestaurant.get();
        }

        return null;
    }

    @Override
    public Optional<Restaurant> getById(Long id) {
        return restaurantRepository.findById(id);
    }

    @Override
    public void editRestaurant(Restaurant restaurant) {
        restaurantRepository.deleteById(restaurant.getId());
        restaurantRepository.save(restaurant);
    }

    @Override
    public void removeRestaurant(Long id) {
        restaurantRepository.deleteById(id);
    }

    @Override
    public boolean isNameUsed(String name) {
        Optional<Restaurant> n =  restaurantRepository.findByName(name);
        if(n.isPresent()){
            return true;
        }
        else{
            return false;
        }

    }
}
