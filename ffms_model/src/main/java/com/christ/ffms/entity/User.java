package com.christ.ffms.entity;

import org.springframework.stereotype.Component;

@Component
public class User {
    private  int id;
    private String name;
    private String realname;
    private String pwd;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    public User(){

    }
    public User(String name, String realname, String pwd) {
        this.name = name;
        this.realname = realname;
        this.pwd = pwd;
    }
    public User(String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
    }
    public User(int id, String name, String realname, String pwd) {
        this.id = id;
        this.name = name;
        this.realname = realname;
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", realname='" + realname + '\'' +
                ", pwd='" + pwd + '\'' +
                '}'+"\n";
    }
}
