package Restaurant.Restaurant.User.controller;

import Restaurant.Restaurant.Order.Model.OrderModel;
import Restaurant.Restaurant.Order.service.OrderService;
import Restaurant.Restaurant.Restaurant.Model.Restaurant;
import Restaurant.Restaurant.Restaurant.service.RestaurantService;
import Restaurant.Restaurant.User.Model.User;
import Restaurant.Restaurant.User.service.UserService;
import Restaurant.Restaurant.User.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    OrderService orderService;

    @Autowired
    RestaurantService restaurantService;

    @GetMapping("/homepage")
    public String userHomePage(Model model){

        Restaurant actRestaurant = null;

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            model.addAttribute("currentUserName", currentUserName);
            Optional<User> user = userService.getByUsername(currentUserName);
            if(user.isPresent()) {
                actRestaurant = user.get().getRestaurant();
                model.addAttribute("currentUserRestaurant", actRestaurant.getName());
            }
        }

        Restaurant finalActRestaurant = actRestaurant;
        orderService.getAll().stream().filter(p->p.getRestaurant().getName().equals(finalActRestaurant.getName())).collect(Collectors.toList());

        System.out.println(orderService.getAll());


        return "homepage";
    }

    @PostMapping("/addOrder")
    public String addOrder(Model model,
                           @RequestParam("nazwa") String nazwa,
                           @RequestParam("restauracja") String restauracja,
                           @RequestParam("data") LocalDate data,
                           @RequestParam("dania") String dania){

        User actUser = null;
        Optional<User> OptactUser = userService.getByUsername(this.getUsername());
        if(OptactUser.isPresent()){
            actUser = OptactUser.get();
        }


        //TODO select Dishes

        OrderModel order = new OrderModel();
        order.setDate(data);
        order.setRestaurant(restaurantService.getByName(restauracja));
        order.setUser(actUser);
//        order.setDishes();
//        order.setPrice();

        //TODO Add to database
        return "/user/homepage";
    }

    public String getUsername(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            return currentUserName;

        }
        return null;
    }

}
