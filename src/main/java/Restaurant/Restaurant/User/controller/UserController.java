package Restaurant.Restaurant.User.controller;

import Restaurant.Restaurant.User.Model.User;
import Restaurant.Restaurant.User.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping("/getAll")
    public List<User> getAll(){
        return userService.getAll();
    }

    @GetMapping("/get={name}")
    public User getByName(@PathVariable String username){
        return userService.getByUsername(username);
    }

    @PostMapping("/add")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

}
