package ru.itis.anno.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.model.User;

@Controller
public class SimpleController {


    @RequestMapping(value = "/showUsersSimple", method = RequestMethod.GET)
    @ResponseBody
    public String showUsers() {
        String user = "Marsel 23";
        return user;
    }

    @RequestMapping(value = "/someQuery", method = RequestMethod.GET)
    public String someQuery() {
        return "/user";
    }

    @RequestMapping(value = "/showUserAsGood", method = RequestMethod.GET)
    public ModelAndView getUser() {
        User user = new User(123L, 23, "Marsel", null);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user");
        modelAndView.addObject("userJSP", user);
        return modelAndView;
    }
}
