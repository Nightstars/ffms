package com.christ.ffms.control;

import com.christ.ffms.entity.User;
import com.christ.ffms.service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Data
@Controller
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping(value = "listUser")
    @ResponseBody
    public List<User> listUser(){
        return userService.ListUser();
    }
    @RequestMapping(value = "toHome.html",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String login(String name,String password){
        User user=new User(name,password);
        if(userService.login(user)){
            return "ok";
        }else{
            return "用户名或密码错误";
        }
    }
    @RequestMapping("login.html")
    public String toLogin(){
        return "login";
    }
    @RequestMapping("home.html")
    public String toHome(){
        return "home";
    }
    @RequestMapping("toUserList")
    public String toUserList(){
        return "/user/list";
    }
    @RequestMapping("toUserAdd")
    public String toUserAdd(){
        return "/user/add";
    }
    @RequestMapping("toUserDetail")
    public ModelAndView toUserDetail(Integer id){
        ModelAndView modelAndView=new ModelAndView("/user/detail","user",userService.getUserById(id));
        return modelAndView;
    }
    @RequestMapping("toUserEdit")
    public ModelAndView toUserEdit(Integer id){
        ModelAndView modelAndView=new ModelAndView("/user/edit","user",userService.getUserById(id));
        return modelAndView;
    }
    @RequestMapping("addUser")
    @ResponseBody
    public String addUser(User user){
       userService.addUser(user);
        return "toUserList";
    }
    @RequestMapping(value = "deleteUser")
    public String deleteUser(Integer id){
        userService.deleteUser(id);
        return "/user/list";
    }
    @RequestMapping(value = "modifyUser")
    @ResponseBody
    public String deleteUser(User user){
        userService.modifyUser(user);
        return "toUserList";
    }
    @RequestMapping(value = "deleteUserArray")
    @ResponseBody
    public String deleteUserArray(String[] arr){
        userService.deleteUserArr(arr);
        return "toUserList";
    }
}
