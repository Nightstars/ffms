package com.christ.ffms.control;

import com.christ.ffms.entity.User;
import com.christ.ffms.service.UserService;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        UserService userService=new UserService();
        User user=new User(request.getParameter("name"),"",request.getParameter("password"));
        if(userService.login(user)){
            HttpSession session=request.getSession();
            session.setAttribute("name",user.getName());
            response.getWriter().println("ok");
        }else{
           response.getWriter().println("用户名或密码错误");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
