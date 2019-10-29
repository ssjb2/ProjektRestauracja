package Restaurant.Restaurant.User.service;

import javax.annotation.PostConstruct;
import Restaurant.Restaurant.User.Model.User;
import Restaurant.Restaurant.User.repository.UserRepository;
import Restaurant.Restaurant.User.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
    public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repository;

    @Override
    public void addUser(User user) {
        repository.save(user);
    }

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<User> getByUsername(String username) {
        {
            return repository.findByUsername(username);
        }
    }
}