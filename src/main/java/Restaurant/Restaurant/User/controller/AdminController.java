package Restaurant.Restaurant.User.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller

@RequestMapping(("/admin"))
public class AdminController {

    @GetMapping("/homepage")

    public String adminHomePage(){
        return "adminHomepage";
    }
}
