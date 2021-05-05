package dao;

import entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO<U extends User>{
    void addUser(User user) throws SQLException;
    void update(User user) throws SQLException;
    void delete(String email) throws SQLException;
    List<User> readAll() throws SQLException;
    User getByID(String email) throws SQLException;



}
