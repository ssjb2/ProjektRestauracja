package Restaurant.Restaurant.Order.service;

import Restaurant.Restaurant.Order.Model.OrderModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {

    public void addOrder(OrderModel order);

    public List<OrderModel> getAll();


}
