package Restaurant.Restaurant.Dish.service;


import Restaurant.Restaurant.Dish.Model.Dish;
import Restaurant.Restaurant.Dish.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DishServiceImpl implements Dishservice {

    @Autowired
    private DishRepository repository;

    @Override
    public void addDish(Dish dish) {
        repository.save(dish);
    }

    @Override
    public List<Dish> getAll() {
        return repository.findAll();
    }

    @Override
    public Dish getByName(String dishname) {
        return repository.findByName(dishname);
    }

    @Override
    public Optional<Dish> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void editDish(Dish dish) {
        repository.deleteById(dish.getId());
        repository.save(dish);
    }

    @Override
    public void removeDish(Long id) {
        repository.deleteById(id);
    }

}
