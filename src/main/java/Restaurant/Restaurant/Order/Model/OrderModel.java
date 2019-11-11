package Restaurant.Restaurant.Order.Model;

import Restaurant.Restaurant.Dish.Model.Dish;
import Restaurant.Restaurant.Restaurant.Model.Restaurant;
import Restaurant.Restaurant.User.Model.Role;
import Restaurant.Restaurant.User.Model.User;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orderr")
public class OrderModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="Restaurant_id")
    private Restaurant restaurant;

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name="User_id")
    private User user;

    @ManyToMany(cascade = { CascadeType.ALL })
    private List<Dish> dishes;

    private float price;



}
