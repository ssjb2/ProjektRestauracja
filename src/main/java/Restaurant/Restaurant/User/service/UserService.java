package Restaurant.Restaurant.User.service;

import Restaurant.Restaurant.User.Model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public void addUser(User user);

    public List<User> getAll();

    public User getByUsername(String username);
}
