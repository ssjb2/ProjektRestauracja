package Restaurant.Restaurant.User.service;

import Restaurant.Restaurant.User.Model.User;
import Restaurant.Restaurant.User.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository repository;

    @Override
    public void addUser(User user){
        repository.save(user);
    }

    @Override
    public List<User> getAll(){
        return repository.findAll();
    }

    @Override
    public Optional<User> getByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public Optional<User> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public boolean isUserExist(User user) {
        return repository.existsById(user.getId());
    }

    @Override
    public void editUser(User user) {
        repository.update(user.getFirstName(),user.getLastName(),user.getUsername(),user.getPassword());
    }

    @Override
    public User editUserById(Long id) {
        return null;
    }

}
