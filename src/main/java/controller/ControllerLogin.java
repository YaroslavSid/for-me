package controller;


import service.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.SQLException;

@WebServlet("/login")
public class ControllerLogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp){
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        Service service = new Service();
        String role = service.checkRole(email, password);
        switch (role) {
            case "admin":
                try {
                    resp.sendRedirect("/success/success_admin.jsp");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "user":
                boolean findUser;
                try {
                    findUser = service.checkLogin(email, password);
                    if (findUser) {
                        try {
                            resp.sendRedirect("/success/success_user.jsp");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        try {
                            resp.sendRedirect("/login/login_repeat.jsp");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;

        }
    }

}
