package com.christ.ffms.control;

import com.christ.ffms.entity.Account;
import com.christ.ffms.entity.Item;
import com.christ.ffms.entity.Search;
import com.christ.ffms.entity.User;
import com.christ.ffms.service.AccountService;
import com.christ.ffms.service.ItemService;
import com.christ.ffms.service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Data
@Controller
public class AccountController {
    @Autowired
    AccountService accountService;
    @Autowired
    UserService userService;
    @Autowired
    ItemService itemService;
    @RequestMapping("toAccountList")
    public ModelAndView toHome(Integer pageNum,Integer pageSize){
        //System.out.println(accountService.getAllAccount());
        ModelAndView modelAndView=new ModelAndView("/account/list","accounts",accountService.getPage(pageNum,pageSize).getResult());
        return modelAndView;
    }
    @RequestMapping("findAccount")
    @ResponseBody
    public List<Account> findAccount(Search search){
        System.out.println(search);
        System.out.println(accountService.getAccountByDate(search));
        return accountService.getAccountByDate(search);
    }
    @RequestMapping("xxx")
    @ResponseBody
    public List<Account> test(){
        return accountService.getAllAccount();
    }
    @RequestMapping("deleteAccount")
    public ModelAndView deleteAccount(Integer id){
        accountService.deleteAccount(id);
        ModelAndView modelAndView=new ModelAndView("/account/list","accounts",accountService.getPage(1,10).getResult());
        return modelAndView;
    }
    @RequestMapping("showAccount")
    public ModelAndView showAccount(Integer id){
        ModelAndView modelAndView=new ModelAndView("/account/detail","account",accountService.getAccountById(id));
        return modelAndView;
    }
    @RequestMapping("toAccountAdd")
    public ModelAndView toAccountAdd(){
        ModelAndView modelAndView=new ModelAndView("/account/add","user",userService.ListUser());
        modelAndView.addObject("items",itemService.listItem());
        return modelAndView;
    }
    @RequestMapping("toAccountEdit")
    public ModelAndView toAccountEdit(Integer id){
        ModelAndView modelAndView=new ModelAndView("/account/edit","account",accountService.getAccountById(id));
        modelAndView.addObject("user",userService.ListUser());
        modelAndView.addObject("item",itemService.listItem());
        return modelAndView;
    }
    @RequestMapping("toAccountFind")
    public String toAccountFind(){
        return "/account/find";
    }
    @RequestMapping("addAccount")
    @ResponseBody
    public String addAccount(Account account,Integer uid,Integer iid){
        User user=new User();
        user.setId(uid);
        Item item=new Item();
        item.setId(iid);
        account.setUser(user);
        account.setItem(item);
        System.out.println(account);
        accountService.addAccount(account);
        return "toAccountList?pageNum=1&pageSize=10";
    }
    @RequestMapping("editAccount")
    @ResponseBody
    public String editAccount(Account account,Integer uid,Integer iid){
        User user=new User();
        user.setId(uid);
        Item item=new Item();
        item.setId(iid);
        account.setUser(user);
        account.setItem(item);
        System.out.println(account);
        accountService.editAccount(account);
        return "toAccountList?pageNum=1&pageSize=10";
    }
}
