package com.christ.ffms.service;

import com.christ.ffms.dao.AccountDao;
import com.christ.ffms.entity.Account;
import com.christ.ffms.entity.Search;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Data
public class AccountService {
    @Autowired
    AccountDao accountDao;
    @Transactional(readOnly = true, rollbackFor = Exception.class,isolation = Isolation.READ_COMMITTED,timeout = 3)
    public List<Account> getAllAccount(){
        List<Account> accounts=accountDao.getAllAccount();
        return accounts;
    }
    @Transactional(readOnly = true, rollbackFor = Exception.class,isolation = Isolation.READ_COMMITTED,timeout = 3)
    public List<Account> getAccountByDate(Search search){
        List<Account> accounts=accountDao.getAccountByDate(search);
        return accounts;
    }
    @Transactional(readOnly = true, rollbackFor = Exception.class,isolation = Isolation.READ_COMMITTED,timeout = 3)
    public Page<Account> getPage (int pageNum, int pageSize){
        Page<Account> page1 =  PageHelper.startPage(pageNum,pageSize);
        accountDao.getAllAccount();
        return page1;
    }
    @Transactional(readOnly = true, rollbackFor = Exception.class,isolation = Isolation.READ_COMMITTED,timeout = 3)
    public Account getAccountById(Integer id){
        Account account=accountDao.getAccountById(id);
        return account;
    }
    @Transactional(readOnly = false, rollbackFor = Exception.class,isolation = Isolation.READ_COMMITTED,timeout = 3)
    public void deleteAccount(Integer id){
        accountDao.deleteAccount(id);
    }
    @Transactional(readOnly = false, rollbackFor = Exception.class,isolation = Isolation.READ_COMMITTED,timeout = 3)
    public void addAccount(Account account){
        accountDao.addAccount(account);
    }
    @Transactional(readOnly = false, rollbackFor = Exception.class,isolation = Isolation.READ_COMMITTED,timeout = 3)
    public void editAccount(Account account){
        accountDao.editAccount(account);
    }
}
