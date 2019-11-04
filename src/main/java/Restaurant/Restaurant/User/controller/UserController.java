package Restaurant.Restaurant.User.controller;

import Restaurant.Restaurant.User.Model.User;
import Restaurant.Restaurant.User.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImpl userService;


    @GetMapping("/getAll")
    public List<User> getAll(){
        return userService.getAll();
    }

    @GetMapping("/get={name}")
    public Optional<User> getByName(@PathVariable String username){
        return userService.getByUsername(username);
    }


    @PostMapping("/add")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    @GetMapping("/user/homepage")
    public String userHomePage(){
        return "userHomePage";
    }

    @GetMapping("/admin/homepage")
    public String adminHomePage(){
        return "userHomePage";
    }


}
