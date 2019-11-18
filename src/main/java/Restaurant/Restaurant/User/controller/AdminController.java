package Restaurant.Restaurant.User.controller;

import Restaurant.Restaurant.Dish.service.Dishservice;
import Restaurant.Restaurant.Restaurant.service.RestaurantService;
import Restaurant.Restaurant.User.Model.Role;
import Restaurant.Restaurant.User.Model.User;
import Restaurant.Restaurant.User.repository.RoleRepository;
import Restaurant.Restaurant.User.service.UserService;
import Restaurant.Restaurant.Wrapper.userWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(("/admin"))
public class AdminController {

    @Autowired
    UserService userService;

    @Autowired
    Dishservice dishservice;

    @Autowired
    RestaurantService restaurantService;

    @Autowired
    RoleRepository roleRepository;


    @GetMapping("/homepage")
    public String adminHomePage(Model model){

        model.addAttribute("currentUserName", getCurrentUserName());

        return "adminHomepage";
    }

    @GetMapping("/listUsers")
    public String listUsers(Model model){

        model.addAttribute("currentUserName", getCurrentUserName());
        model.addAttribute("users",userService.getAll());

        return "users/listUsers";
    }

    @GetMapping("/listDishes")
    public String listDishes(Model model){

        model.addAttribute("currentUserName", getCurrentUserName());
        model.addAttribute("dishes",dishservice.getAll());

        return "dishes/listDishes";
    }

    @GetMapping("/listRestaurants")
    public String listRestaurants(Model model){

        model.addAttribute("currentUserName", getCurrentUserName());
        model.addAttribute("restaurants",restaurantService.getAll());

        return "restaurants/listRestaurants";
    }

    @GetMapping("/editUser/{id}")
    public String editUser(@PathVariable Long id, Model model){

        model.addAttribute("currentUserName", getCurrentUserName());
        model.addAttribute("restaurants",restaurantService.getAll());

        Optional<User> optuser = userService.getById(id);

        if(optuser.isPresent()){
            User user = optuser.get();

            model.addAttribute("firstnameModel", user.getFirstName());
            model.addAttribute("lastnameModel",user.getLastName());
            model.addAttribute("usernameModel", user.getUsername());
            model.addAttribute("passwordModel",user.getPassword());
            model.addAttribute("restaurantModel",user.getRestaurant().getName());
            model.addAttribute("ajdi",user.getId());
        }

        return "/users/editUser";
    }

    @PostMapping("/confirmEditUser/{id}")
    public ModelAndView confirmEditUser(@RequestParam("imie") String imie,
                                        @RequestParam("nazwisko") String nazwisko,
                                        @RequestParam("username") String username,
                                        @RequestParam("password") String password,
                                        @RequestParam("restaurant") String restaurant,
                                        @PathVariable Long id,
                                        Model model){

        userService.removeUser(id);
        //check username is used
        if(userService.isUsernameUsed(username)){
            model.addAttribute("usernameIsUsed",true);
            return new ModelAndView("redirect:/admin/editUser/{id}");
        }
        else{
            userService.addUser(imie, nazwisko, username, password, restaurant);
            model.addAttribute("update",true);
            return new ModelAndView("redirect:/admin/listUsers");
        }
    }

    @GetMapping("/newUser")
    public String newUser(Model model){

        model.addAttribute("currentUserName", getCurrentUserName());
        model.addAttribute("restaurants",restaurantService.getAll());

        return "/users/newUser";
    }


    @PostMapping("/confirmAddUser")
    @ResponseBody
    public ModelAndView addUser(@RequestParam("imie") String imie,
                                @RequestParam("nazwisko") String nazwisko,
                                @RequestParam("username") String username,
                                @RequestParam("password") String password,
                                @RequestParam("restaurant") String restaurant,
                                Model model){

        //check username is used
        if(userService.isUsernameUsed(username)){
            model.addAttribute("usernameIsUsed",true);
            return new ModelAndView("redirect:/admin/newUser");
        }
        else{
            userService.addUser(imie, nazwisko, username, password, restaurant);
            model.addAttribute("add", true);
            return new ModelAndView("redirect:/admin/listUsers");
        }
    }

    @GetMapping("/removeUser/{id}")
    public ModelAndView removeUser(@PathVariable Long id, Model model){

        userService.removeUser(id);
        model.addAttribute("remove",true);

        return new ModelAndView("redirect:/admin/listUsers");
    }



    private String getCurrentUserName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            return currentUserName;
        }
        else{
            return "default";
        }
    }


}
