package Restaurant.Restaurant.User.controller;

import Restaurant.Restaurant.Dish.Product.model.Product;
import Restaurant.Restaurant.Dish.singleDish.Model.Dish;
import Restaurant.Restaurant.Dish.singleDish.service.DishService;
import Restaurant.Restaurant.Order.Model.OrderModel;
import Restaurant.Restaurant.Order.service.OrderService;
import Restaurant.Restaurant.Restaurant.Model.Restaurant;
import Restaurant.Restaurant.Restaurant.service.RestaurantService;
import Restaurant.Restaurant.User.Model.User;
import Restaurant.Restaurant.User.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Controller
@RequestMapping("/user")
@SessionAttributes("actCart")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    OrderService orderService;

    @Autowired
    RestaurantService restaurantService;

    @Autowired
    DishService dishService;



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

        model.addAttribute("message","testmessage");
        //add Dishes to model
        List<Dish> dishes = dishService.getAll();
        model.addAttribute("dishes",dishes);
        System.out.println(dishes);

//        Restaurant finalActRestaurant = actRestaurant;
//        orderService.getAll().stream().filter(p->p.getRestaurant().getName().equals(finalActRestaurant.getName())).collect(Collectors.toList());

        // System.out.println(orderService.getAll());

        return "homepage";
    }

    @GetMapping("/newOrder")
    public String newOrder(Model model){
        model.addAttribute("currentUserName", this.getUsername());

        List<Dish> listAllDishes = dishService.getAll();


        model.addAttribute("listAllDishes", listAllDishes);
        return "order/newOrder";
    }



    @RequestMapping(value = "addProduct/{id}", method = RequestMethod.GET)
    public String addProduct(@PathVariable("id") String id,
                             HttpSession session){

        OrderModel order = new OrderModel();
        if (session.getAttribute("cart") == null) {
            List<Product> cart = new ArrayList<>();

            //if exist add to cart
            Optional<Dish> tempDish = dishService.getById(Long.valueOf(id));

            if(tempDish.isPresent()){
                cart.add(new Product(tempDish.get()));
            }

            session.setAttribute("cart", cart);
        } else {
            List<Product> cart = (List<Product>) session.getAttribute("cart");

            //if exist add to cart
            Optional<Dish> tempDish = dishService.getById(Long.valueOf(id));

            int index = this.exists(id, cart);

            if (index == -1) {
                Optional<Dish> tempDish2 = dishService.getById(Long.valueOf(id));

                if(tempDish.isPresent()){
                    cart.add(new Product(tempDish2.get()));
                }
            } else {
                int quantity = cart.get(index).getQuantity() + 1;
                cart.get(index).setQuantity(quantity);
                cart.get(index).calcPrice();
            }
            session.setAttribute("cart", cart);
        }

        session.setAttribute("total",this.calcTotalPrice((List<Product>) session.getAttribute("cart")));

        return "order/cart";
    }

    @RequestMapping(value = "remove/{id}", method = RequestMethod.GET)
    public String remove(@PathVariable("id") String id, HttpSession session) {

        Dish dish = new Dish();
        List<Product> cart = (List<Product>) session.getAttribute("cart");
        int index = this.exists(id, cart);
        cart.remove(index);
        session.setAttribute("cart", cart);
        session.setAttribute("total",this.calcTotalPrice((List<Product>) session.getAttribute("cart")));
        return "order/cart";

    }

    @GetMapping("confirmAddOrder")
    public String confirmAddOrder(HttpSession session,Model model){
        OrderModel order = new OrderModel();

        Optional<User> user = userService.getByUsername(this.getUsername());

        if(user.isPresent()){
            order.setUser(user.get());
            order.setRestaurant(user.get().getRestaurant());
        }

        order.setDate(LocalDateTime.now());
        order.setProducts((List<Product>) session.getAttribute("cart"));
        order.setPrice(this.calcTotalPrice(order.getProducts()));
        order.setStatus("nowe");

        orderService.addOrder(order);
        session.removeAttribute("cart");
        session.removeAttribute("total");

        model.addAttribute("add",true);
        return "homepage";
    }

    private float calcTotalPrice(List<Product> products){
        float sum=0;
        for(Product xx: products){
            sum += xx.getPrice();
        }
        return sum;
    }

    private int exists(String id, List<Product> cart) {
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getDish().getId().toString().equals(id)) {
                return i;
            }
        }
        return -1;
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
