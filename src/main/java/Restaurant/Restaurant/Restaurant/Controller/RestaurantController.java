package Restaurant.Restaurant.Restaurant.Controller;
import Restaurant.Restaurant.Restaurant.Model.Restaurant;
import Restaurant.Restaurant.Restaurant.service.RestaurantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    RestaurantServiceImpl restaurantService;





    @PostMapping("/add")
    public void addRestaurant(@RequestBody Restaurant restaurant)
    {restaurantService.addRestaurant(restaurant);}

}
