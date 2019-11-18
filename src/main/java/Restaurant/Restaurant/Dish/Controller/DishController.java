package Restaurant.Restaurant.Dish.Controller;


import Restaurant.Restaurant.Dish.Model.Dish;
import Restaurant.Restaurant.Dish.service.DishServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/dish")
public class DishController {

    @Autowired
    DishServiceImpl dishService;





    @PostMapping("/add")
    public void addDish(@RequestBody Dish dish)
    {dishService.addDish(dish);}


    @PostMapping("/editDish")
    public void editDish(@RequestBody Dish dish) {
        dishService.editDish(dish);
    }

    @GetMapping("/editDishById={id}")
    public void editDish(@PathVariable Long id) {
        Optional<Dish> tempOptDish = dishService.getById(id);

        if(tempOptDish.isPresent()){
            dishService.editDish(tempOptDish.get());
        }
    }

    @PostMapping("/removeDish")
    public void removeDish(@RequestBody Dish dish){
        dishService.removeDish(dish.getId());
    }

    @GetMapping("removeDishById={id}")
    public void removeDish(@PathVariable Long id){
        Optional<Dish> tempOptDish = dishService.getById(id);

        if(tempOptDish.isPresent()){
            dishService.editDish(tempOptDish.get());
        }
        dishService.removeDish(id);

    }
}
