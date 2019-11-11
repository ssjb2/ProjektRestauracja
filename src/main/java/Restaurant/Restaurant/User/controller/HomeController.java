package Restaurant.Restaurant.User.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {

    @GetMapping("/login")
    public String login(Model model){
        return "login";
    }

    @GetMapping("/logout")
    public String logout(){
        return "login";
    }

    @RequestMapping(value="/", method= RequestMethod.GET)
    public String home(Model model){
        return "login";
    }
}
