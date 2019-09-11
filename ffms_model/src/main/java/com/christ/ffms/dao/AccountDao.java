package com.christ.ffms.dao;

import com.christ.ffms.entity.Account;

import java.util.Date;
import java.util.List;

public interface AccountDao {
    /*void saveAccount(Account account);
    void updateAccount(Account account);
    void deleteAccount(int id);
    void deleteAccount(String[] ids);*/
    Account getAccountById(int id);
    /*List<Account> getPagesAccounts(int pageNum,int pageSize);
    List<Account> getPagesAccountsByDate(int pageNum, int pageSize, Date startDate,Date endDate);*/
}
