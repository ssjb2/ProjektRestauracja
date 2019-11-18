package Restaurant.Restaurant.Restaurant.Controller;
import Restaurant.Restaurant.Restaurant.Model.Restaurant;
import Restaurant.Restaurant.Restaurant.service.RestaurantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    RestaurantServiceImpl restaurantService;





    @PostMapping("/add")
    public void addRestaurant(@RequestBody Restaurant restaurant)
    {restaurantService.addRestaurant(restaurant);}

    @PostMapping("/editRestaurant")
    public void editRestaurant(@RequestBody Restaurant restaurant) {
        restaurantService.editRestaurant(restaurant);
    }

    @GetMapping("/editRestaurantById={id}")
    public void editRestaurant(@PathVariable Long id) {
        Optional<Restaurant> tempOptRestaurant = restaurantService.getById(id);

        if(tempOptRestaurant.isPresent()){
            restaurantService.editRestaurant(tempOptRestaurant.get());
        }
    }

    @PostMapping("/removeRestaurant")
    public void removeRestaurant(@RequestBody Restaurant restaurant){
        restaurantService.removeRestaurant(restaurant.getId());
    }

    @GetMapping("removeRestaurantById={id}")
    public void removeRestaurant(@PathVariable Long id){
        Optional<Restaurant> tempOptRestaurant = restaurantService.getById(id);

        if(tempOptRestaurant.isPresent()){
            restaurantService.editRestaurant(tempOptRestaurant.get());
        }
        restaurantService.removeRestaurant(id);

    }

}
