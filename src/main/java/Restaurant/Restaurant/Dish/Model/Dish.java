package Restaurant.Restaurant.Dish.Model;


import Restaurant.Restaurant.Order.Model.OrderModel;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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



}
