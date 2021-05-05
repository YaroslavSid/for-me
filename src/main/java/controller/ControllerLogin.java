package controller;


import service.Service;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

@WebServlet("/login")
public class ControllerLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/login/login.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        Service service = new Service();

        String findRole = service.checkRole(email, password);
        switch (findRole) {
            case "admin":
                    resp.sendRedirect("/success/success_admin.jsp");
                break;
            case "user":
                boolean findUser;
                try {
                    password = service.MD5(password);
                    findUser = service.checkLogin(email, password);
                    if (findUser) {
                            resp.sendRedirect("/success/success_user.jsp");
                    } else {
                            resp.sendRedirect("/login/login_repeat.jsp");
                    }
                } catch (SQLException | NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

}
