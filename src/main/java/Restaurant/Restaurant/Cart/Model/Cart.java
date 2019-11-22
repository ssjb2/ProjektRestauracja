package Restaurant.Restaurant.Cart.Model;

import Restaurant.Restaurant.Dish.singleDish.Model.Dish;
import lombok.*;

import javax.persistence.*;
import java.util.List;


@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cartName;

    @ManyToMany(cascade = { CascadeType.ALL })
    private List<Dish> dishes;


    public void addDish(Dish dish) {
        System.out.println(dish.getName()+" wft ");
        System.out.println(dish);
        dishes.add(dish);
    }
}
