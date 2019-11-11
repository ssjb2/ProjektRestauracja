package Restaurant.Restaurant.Dish.Model;


import Restaurant.Restaurant.Order.Model.OrderModel;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "dish")
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private float price;

    @ManyToMany(mappedBy = "dishes")
    private List<OrderModel> orders;


    public Dish() {

    }

    public Dish(String name, float price) {
        this.name = name;

        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
