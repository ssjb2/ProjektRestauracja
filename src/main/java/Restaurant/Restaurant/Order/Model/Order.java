package Restaurant.Restaurant.Order.Model;

import Restaurant.Restaurant.Restaurant.Dish;
import Restaurant.Restaurant.Restaurant.Model.Restaurant;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "Order")

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    private Restaurant Restaurant;
    private List<Dish> Dish;
    private float price;

    public Order(Long id, Restaurant restaurant, List<Dish> dish, float price){
        this.id = id;
        Restaurant = restaurant;
        Dish = dish;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Restaurant getRestaurant(){
        return Restaurant;
    }
    public void setRestaurant(Restaurant restaurant){
        Restaurant = restaurant;
    }
    public List<Dish> getDish(){
        return Dish;
    }
    public void setDish(List<Dish> dish){
        Dish = dish;
    }
    public float getPrice(){
        return price;
    }
    public void setPrice(float price){
        this.price = price;
    }

}
