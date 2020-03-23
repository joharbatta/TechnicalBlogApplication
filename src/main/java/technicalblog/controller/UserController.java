package technicalblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import technicalblog.dao.postDAO;
import technicalblog.model.User;
import technicalblog.service.userService;


@Controller
public class UserController {

    @RequestMapping("users/login")  //when get request by default
    public String login() {
        return "users/login";
    }

    @RequestMapping("users/registration")
    public String registration() {
        return "users/registration";
    }

    @RequestMapping(value = "users/login", method= RequestMethod.POST)
    public String loginUser(User user) {
//        boolean name=user.getUsername().equals("abc");
//        boolean pwd=user.getPassword().equals("123");
//        boolean check=false;
        userService u=new userService();
        boolean flag=u.isValidUser(user);
        if(flag)
        {
            return "redirect:/posts";
        }
        else {
            return "users/login";
        }
    }


}

//
////dependency injection
////here we cant change pizza property as type of pizza hardcode tight coupling
//class Food{
//    Pizza p=new Pizza();
//    void eat()
//    {
//        p.eat();
//    }
//}
//// 1st method setter injection
//
//class Food{
//    Pizza p;
//
//    void setPizza(Pizza p)
//    {
//        this.p=p;
//    }
//    void eat()
//    {
//        p.eat();
//    }
//}
//Food f=new Food();
//f.setPizza(new CheezPizza());
//f.eat();
//
////constructor method
//
//class Food{
//   private  Pizza p;
//
//   Food(Pizza p)
//    {
//        this.p=p;
//
//    }
//
//    void setPizza(Pizza p)
//    {
//        this.p=p;
//    }
//    void eat()
//    {
//        p.eat();
//    }
//}
//Food f=new Food(new Pizza());
//f.setPizza(new CheezPizza());
//        f.eat();



