package controller;

import dao.impl.UserDAOImpl;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.SQLException;
import java.util.List;

//@WebServlet("/login")
public class Controller extends HttpServlet {
    User user = new User();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//      String email = req.getParameter("email");
        resp.getWriter().write("dfsafds");








//      String password = req.getParameter("password");
//      user.setEmail(email);
//      user.setPassword(password);

//      resp.sendRedirect("");
//      resp.sendRedirect("n.html");
    }













    //    public static void main(String[] args){
//        UserDAOImpl userDAO = new UserDAOImpl();
//        User dddd = new User();
//        dddd.setName("LKLK");
//        dddd.setLastName("hgjfgK");
//        dddd.setEmail("yaroslgv@gmail.com");
//        dddd.setPassword("777");
//        try {
//                    userDAO.addUser(dddd);
//                } catch (SQLException throwables) {
//                    throwables.printStackTrace();
//                }
//        dddd.setName("Luke");
//        dddd.setLastName("Wake");
//        dddd.setEmail("yaroslav@gmail.com");
//        dddd.setPassword("000000");
//        try {
//            userDAO.update(dddd);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }


//
//        List<User> allUser = userDAO.readAll();
//        for (User user : allUser){
//            System.out.println(user);
//        }





//        try {
//            User dddd = userDAO.getByID("yaroslav@gmail.com");
//            if(dddd == null){
//                System.out.println("Not fount");
//
//            }System.out.println(dddd);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }

//
//                try {
//                    userDAO.delete("yaroslgv@gmail.com");
//                } catch (SQLException throwables) {
//                    throwables.printStackTrace();
//                }
//
//
//
//
//
//    }
}
