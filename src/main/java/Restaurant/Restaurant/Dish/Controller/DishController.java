package Restaurant.Restaurant.Dish.Controller;


import Restaurant.Restaurant.Dish.Model.Dish;
import Restaurant.Restaurant.Dish.service.DishService;
import Restaurant.Restaurant.Dish.service.DishServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("admin/dish")
public class DishController {

    @Autowired
    DishService dishService;

    @GetMapping("/listDishes")
    public String listDishes(Model model){

        model.addAttribute("currentUserName", getCurrentUserName());
        model.addAttribute("dishes",dishService.getAll());

        return "dishes/listDishes";
    }

    @GetMapping("/newDish")
    public String newRestaurant(Model model){
        model.addAttribute("currentUserName", getCurrentUserName());
        return "/dishes/newDish";
    }

    @PostMapping("/confirmAddDish")
    @ResponseBody
    public ModelAndView addDish(@RequestParam("nazwa") String nazwa,
                                @RequestParam("cena") float cena,
                                Model model){

        //check username is used
        if(dishService.isNameUsed(nazwa)){
            model.addAttribute("nameIsUsed",true);
            return new ModelAndView("redirect:/admin/dish/newDish");
        }
        else{
            dishService.addDish(nazwa, cena);
            model.addAttribute("add", true);
            return new ModelAndView("redirect:/admin/dish/listDishes");
        }
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
