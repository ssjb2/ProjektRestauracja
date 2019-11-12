package Restaurant.Restaurant.User.service;

import Restaurant.Restaurant.User.Model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {

    public void addUser(User user);

    public List<User> getAll();

    public Optional<User> getByUsername(String username);

    public Optional<User> getById(Long id);


    public boolean isUserExist(User user);

    public void editUser(User user);


}
