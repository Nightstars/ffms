package com.christ.ffms.servicetest;

import com.christ.ffms.entity.Account;
import com.christ.ffms.entity.Item;
import com.christ.ffms.entity.Search;
import com.christ.ffms.entity.User;
import com.christ.ffms.service.AccountService;
import com.github.pagehelper.Page;
import lombok.Data;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/spring.xml")
@Data
public class AccountServicesTest {
    @Autowired
    AccountService accountService;
    @Test
    public void getAllTest(){
        List<Account> accounts=accountService.getAllAccount();
        System.out.println(accounts );
    }
    @Test
    public void getPageTest(){
        Page<Account> accounts=accountService.getPage(1,10);
        System.out.println(accounts );
    }
    @Test
    public void getAccountBydateTest(){
        List<Account> accounts=accountService.getAccountByDate(new Search("2019-10-01","2019-10-10",""));
        System.out.println(accounts );
    }
    @Test
    public void editAccountTest(){
        Account account=new Account();
        account.setId(33);
        account.setDate(new Date());
        account.setRemark("test001");
        User user=new User();
        user.setId(9);
        Item item=new Item();
        item.setId(24);
        account.setUser(user);
        account.setItem(item);
        accountService.editAccount(account);
    }
}
