package dao.impl;

import dao.UserDAO;
import entity.User;
import until.ConnectToDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl extends ConnectToDB implements UserDAO<User> {

    private Connection connection = getConnection();

    @Override
    public void addUser(User user) throws SQLException {

        String sql = "INSERT INTO USER (NAME, LAST_NAME, EMAIL, PASSWORD) " +
                "VALUE(?,?,?,?);";
        try(PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, user.getName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPassword());

            statement.executeUpdate();
            
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }

    }


    @Override
    public void delete(String email) throws SQLException {
        String sql = "DELETE FROM USER WHERE email = ?";
        if (connection == null){
            connection = getConnection();
        }
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1,email);

            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if (connection != null) {
                connection.close();
            }
        }


    }

    @Override
    public List<User> readAll() throws SQLException {
        List<User> allUser = new ArrayList<>();
        String sql = "SELECT NAME,LAST_NAME,EMAIL,PASSWORD FROM USER";
        try (Statement statement = connection.createStatement()){

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                User user = new User();
                user.setName(resultSet.getString("NAME"));
                user.setLastName(resultSet.getString("LAST_NAME"));
                user.setEmail(resultSet.getString("EMAIL"));
                user.setPassword(resultSet.getString("PASSWORD"));
                allUser.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if (connection != null) {
                connection.close();
            }
        }
        return allUser;
    }

    @Override
    public User getByID(String email) throws SQLException {
        User user = new User();
        String sql = "SELECT NAME,LAST_NAME,EMAIL, password FROM USER WHERE EMAIL = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, email);

            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            user.setName(resultSet.getString("NAME"));
            user.setLastName(resultSet.getString("LAST_NAME"));
            user.setEmail(resultSet.getString("EMAIL"));
            user.setPassword(resultSet.getString("PASSWORD"));
            return user;

        } catch (SQLException e) {
            return  null;
        } finally {
            if (connection != null) {
                connection.close();
            }
        }

    }



//create change email!!!!!!!!!!!!!!
    @Override
    public void update(User user) throws SQLException {
        String sql = "UPDATE USER SET NAME = ?, LAST_NAME = ?," +
                " PASSWORD = ? WHERE EMAIL = ?";

        try(PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1,user.getName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getPassword());
            statement.setString(4,user.getEmail());

            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            if (connection != null) {
                connection.close();
            }
        }
    }
}
