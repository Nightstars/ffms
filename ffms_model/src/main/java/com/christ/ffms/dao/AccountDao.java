package com.christ.ffms.dao;

import com.christ.ffms.entity.Account;
import com.christ.ffms.entity.Search;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AccountDao {
    Account getAccountById(int id);
    public List<Account> getAllAccount();
    public void deleteAccount(Integer id);
    public void addAccount(Account account);
    public void editAccount(Account account);
    public List<Account> getAccountByDate(Search search);
}
