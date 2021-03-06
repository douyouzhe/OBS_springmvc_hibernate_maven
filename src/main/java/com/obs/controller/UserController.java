package com.obs.controller;


import com.obs.Entities.User;
import com.obs.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import utils.WebUtils;

import java.util.Map;

@Controller
@RequestMapping(value = "users")
public class UserController {

    @Autowired
    private UserServices userService;

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public ModelAndView registerUser(User user){
        ModelAndView mv = new ModelAndView("message");
        try{
            user.setId(WebUtils.makeID());
            userService.saveOrUpdateUser(user);
            mv.addObject("msg","registration successful!");
        }catch(Exception e){
            e.printStackTrace();
            mv.addObject("msg","registration fail!");
        }
        return mv;
    }


    @RequestMapping(value = "login", method = RequestMethod.GET)
    public ModelAndView loginUser(@RequestParam("username") String username,
                                  @RequestParam("password") String pwd){
        ModelAndView mv = new ModelAndView("message");
        User user = userService.userLogin(username,pwd);
        if(user!= null){
            mv.addObject("msg","login successful!");
        }
        else{
            mv.addObject("msg","login fail!");

        }
        return mv;
    }
}
