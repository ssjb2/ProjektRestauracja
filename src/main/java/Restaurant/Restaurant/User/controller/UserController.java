package Restaurant.Restaurant.User.controller;

import Restaurant.Restaurant.User.Model.User;
import Restaurant.Restaurant.User.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @GetMapping("/homepage")
    public String userHomePage(Model model){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            model.addAttribute("currentUserName", currentUserName);
        }

        return "homepage";
    }


    @GetMapping("/getAll")
    public List<User> getAll(){
        return userService.getAll();
    }

    @GetMapping("/getByUserName={username}")
    public Optional<User> getByUsername(@PathVariable String username){
        return userService.getByUsername(username);
    }

    @PostMapping("/addUser")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    @PostMapping("/editUser")
    public void editUser(@RequestBody User user) {
        userService.editUser(user);
    }

    @GetMapping("/editUserById={id}")
    public void editUser(@PathVariable Long id) {
        userService.editUserById(id);
    }






}
