package Restaurant.Restaurant.DailyReport.Model;

import Restaurant.Restaurant.Dish.Product.model.Product;
import Restaurant.Restaurant.Dish.singleDish.Model.Dish;
import Restaurant.Restaurant.Order.Model.OrderModel;
import Restaurant.Restaurant.User.Model.User;
import lombok.*;
import org.springframework.core.annotation.Order;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
@Getter
@Setter
public class DailyReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private HashMap<String, Float> dish_price;

    private HashMap<String, Integer> dish_quantity;

    private float profits;

    @OneToMany(mappedBy = "dailyReport", cascade = CascadeType.ALL)
    private List<OrderModel> orders;

    public DailyReport() {
        orders = new ArrayList<>();
    }

    public void addOrder(OrderModel order) {
        orders.add(order);
        updateDishPrice(order);
        updateDishQuantity(order);
        updateProfits();
    }

    private void updateDishPrice(OrderModel order) {

        if (dish_price == null) {
            dish_price = new HashMap<>();
        }
        for (Product prodakt : order.getProducts()) {
            if (dish_price.containsKey(prodakt.getDish().getName())) {
                float oldValue = dish_price.get(prodakt.getDish().getName());
                oldValue += prodakt.getPrice();
                dish_price.put(prodakt.getDish().getName(), oldValue);
            }
            else {
                dish_price.put(prodakt.getDish().getName(), prodakt.getPrice());
            }
        }
    }

    private void updateDishQuantity(OrderModel order) {

        if (dish_quantity == null) {
            dish_quantity = new HashMap<>();
        }
        for (Product prodakt : order.getProducts()) {
            if (dish_quantity.containsKey(prodakt.getDish().getName())) {
                Integer oldValue = dish_quantity.get(prodakt.getDish().getName());
                oldValue += prodakt.getQuantity();
                dish_quantity.put(prodakt.getDish().getName(), oldValue);
            }
            else {
                dish_quantity.put(prodakt.getDish().getName(), prodakt.getQuantity());
            }
        }
    }


    private void updateProfits() {
        profits = 0;
        for (OrderModel order : orders) {
            for (Product prodakt : order.getProducts()) {
                profits += prodakt.getPrice();
            }
        }
    }
}
