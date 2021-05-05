package service;


import dao.impl.UserDAOImpl;
import entity.User;
import org.apache.commons.validator.routines.EmailValidator;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;


public class Service {

    public boolean checkLogin(String email, String password) throws SQLException {
        UserDAOImpl userDAO = new UserDAOImpl();
        User byID = userDAO.getByID(email);
        if (byID == null) {
            return false;
        }
        return byID.getPassword().equals(password);
    }

    public String checkRole(String email, String password) {
        if (email.equals("admin") & password.equals("123")) {
            return "admin";
        }
        return "user";
    }


    public void registerNewUser(User user) {
        UserDAOImpl userDAO = new UserDAOImpl();

        String password = user.getPassword();

        Service service = new Service();
        try {
            String passwordMD5 = service.MD5(password);
            user.setPassword(passwordMD5);
            userDAO.addUser(user);
        } catch (SQLException | NoSuchAlgorithmException throwables) {
            throwables.printStackTrace();
        }
    }


    public boolean validEmail(String email){
        return EmailValidator.getInstance().isValid(email);
    }


    public String MD5(String password) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        byte[] bytes = messageDigest.digest(password.getBytes());
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b:bytes) {
            stringBuilder.append(String.format("%02X",b));
        }
        return String.valueOf(stringBuilder);
    }
}


