package Restaurant.Restaurant.Dish.service;

import Restaurant.Restaurant.Dish.Model.Dish;

import Restaurant.Restaurant.User.Model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface Dishservice {
    public void addDish(Dish Dish);

    public List<Dish> getAll();

    public Dish getByName(String Dishname);
}
