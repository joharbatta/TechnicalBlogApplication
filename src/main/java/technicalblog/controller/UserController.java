package technicalblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import technicalblog.model.User;

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
        boolean name=user.getUsername().equals("abc");
        boolean pwd=user.getPassword().equals("123");

        if(name && pwd) {
            return "redirect:/posts";
        }
        else {
            return "users/login";
        }
    }


}