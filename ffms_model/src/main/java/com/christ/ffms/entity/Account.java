package com.christ.ffms.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;

@Component
public class Account {
    private int id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private BigDecimal amount;
    private String remark;
    private User user;
    @Autowired
    private Item item;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Account(){

    }
    public Account(int id, Date date, BigDecimal amount, String remark, User user, Item item) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.remark = remark;
        this.user = user;
        this.item = item;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", date=" + date +
                ", amount=" + amount +
                ", remark='" + remark + '\'' +
                ", user=" + user +
                ", item=" + item +
                '}';
    }
}
