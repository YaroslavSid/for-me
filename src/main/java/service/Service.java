package service;


import dao.impl.UserDAOImpl;
import entity.User;

import java.sql.SQLException;


public class Service {
    public static void main(String[] args) {
        Service service = new Service();
        try {
            boolean findUser = service.checkLogin("yaroslav@gmail.com","000000");
        if (findUser){
//            String role = service.checkRole("yaroslav@gmail.com","000000");
            String role = service.checkRole("admin","123");
            System.out.println("true find");
            if (role.equals("admin")){
                System.out.println("admin");
            }else
            {
                System.out.println("user");
            }
        }else {
            System.out.println("not  found");
        }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public boolean checkLogin(String email, String password) throws SQLException {
        UserDAOImpl userDAO = new UserDAOImpl();
        User byID = userDAO.getByID(email);
        if (byID == null) {
            return false;
        }
        return byID.getPassword().equals(password);
    }

    public String checkRole(String email, String password){
        if (email.equals("admin") & password.equals("123")){
            return "admin";
        }
        return "user";
    }
}



//
//    public static void main(String[] args) {
//        UserDAOImpl userDAO = new UserDAOImpl();
//        User dddd = new User();
//        dddd.setName("LKLK");
//        dddd.setLastName("hgjfgK");
//        dddd.setEmail("yaroslgv@gmail.com");
//        dddd.setPassword("000000");
//        try {
//                    userDAO.update(dddd);
//                } catch (SQLException throwables) {
//                    throwables.printStackTrace();
//                }


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
//        List<User> allUser = userDAO.readAll();
//        for (User user : allUser) {
//            System.out.println(user);
//        }
//

