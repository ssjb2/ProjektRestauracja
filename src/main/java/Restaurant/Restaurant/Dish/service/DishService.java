package Restaurant.Restaurant.Dish.service;

import Restaurant.Restaurant.Dish.Model.Dish;

import Restaurant.Restaurant.User.Model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface DishService {

    public List<Dish> getAll();

    public Dish addDish(String nazwa, float cena);

    public Dish getByName(String Dishname);

    public void editDish(Long id, String name,float price);

    public void removeDish(Long id);

    public Optional<Dish> getById(Long id);

    public boolean isNameUsed(String name);
}
