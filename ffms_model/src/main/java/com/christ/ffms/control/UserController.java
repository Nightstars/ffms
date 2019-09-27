package com.christ.ffms.control;

import com.christ.ffms.service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Data
@Controller
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping(value = "listUser",method = RequestMethod.GET)
    public ModelAndView listUser(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("test");
        modelAndView.addObject("users",userService.ListUser());
        return modelAndView;
    }
}
