package Restaurant.Restaurant.User.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @GetMapping("/")
    public String test(){
        return "<b1>//TODO HomePage</b1>";
    }

    @GetMapping("/login")
    public String login(){
        return "//TODO HomePag";
    }

}
