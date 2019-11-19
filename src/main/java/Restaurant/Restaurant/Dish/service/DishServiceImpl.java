package Restaurant.Restaurant.Dish.service;


import Restaurant.Restaurant.Dish.Model.Dish;
import Restaurant.Restaurant.Dish.repository.DishRepository;
import Restaurant.Restaurant.Restaurant.Model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DishServiceImpl implements DishService{


    @Autowired
    DishRepository dishRepository;

    @Override
    public void addDish(Dish dish) {
        dishRepository.save(dish);
    }

    @Override
    public void addDish(String nazwa, float cena) {
        Dish dish = new Dish();
        dish.setName(nazwa);
        dish.setPrice(cena);
        dishRepository.save(dish);
    }

    @Override
    public List<Dish> getAll() {
        return dishRepository.findAll();
    }

    @Override
    public Dish getByName(String dishname){

        Optional<Dish> optionalDish = dishRepository.findByName(dishname);
        if(optionalDish.isPresent()) {
            return optionalDish.get();
        }
        else {
            return null;
        }

    }

    @Override
    public Optional<Dish> getById(Long id) {
        return dishRepository.findById(id);
    }

    @Override
    public void editDish(Dish dish) {
        dishRepository.deleteById(dish.getId());
        dishRepository.save(dish);
    }

    @Override
    public void editDish(Long id, String name, float price) {

    }

    @Override
    public void removeDish(Long id) {
        dishRepository.deleteById(id);
    }

    @Override
    public boolean isNameUsed(String name) {
        Optional<Dish> n = dishRepository.findByName(name);
        if(n.isPresent()){
            return true;
        }
        else{
            return false;
        }

    }
}

