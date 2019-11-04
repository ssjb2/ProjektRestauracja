package Restaurant.Restaurant.Order.service;

import Restaurant.Restaurant.Order.Model.OrderModel;
import Restaurant.Restaurant.Order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository repository;

    @Override
    public void addOrder(OrderModel order){
        repository.save(order);
    }

    @Override
    public List<OrderModel> getAll() { return repository.findAll(); }
}
