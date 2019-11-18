package Restaurant.Restaurant.Dish.service;

import Restaurant.Restaurant.Dish.Model.Dish;

import Restaurant.Restaurant.User.Model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface Dishservice {
    public void addDish(Dish Dish);

    public List<Dish> getAll();

    public Dish getByName(String Dishname);

    public void editDish(Dish dish);

    public void removeDish(Long id);

    public Optional<Dish> getById(Long id);

}
