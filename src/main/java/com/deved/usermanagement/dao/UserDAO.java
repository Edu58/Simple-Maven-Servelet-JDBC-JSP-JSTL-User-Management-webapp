package com.deved.usermanagement.dao;
import com.deved.usermanagement.models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    protected static Connection getDBConnection() {
        Connection connection = null;

        try {
            String JDBCDriver = "com.mysql.cj.jdbc.Driver";

            Class.forName(JDBCDriver);

            String dbPass = "Edwin@254";
            String dbUser = "ed";
            String dbURL = "jdbc:mysql://localhost:3306/java_usermanagement";

            connection = DriverManager.getConnection(dbURL, dbUser, dbPass);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }

    public static User getUser(int id) {
        User user = null;
        try {
            Connection conn = getDBConnection();
            PreparedStatement getUser = conn.prepareStatement("SELECT * FROM users WHERE id=?");
            getUser.setInt(1, id);
            ResultSet rs = getUser.executeQuery();

            while (rs.next()) {
                int user_id =rs.getInt("id");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String email = rs.getString("email");

                user = new User(user_id, firstName, lastName, email);
            }
            return user;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<User> usersList() {
        try {
            Connection conn = getDBConnection();
            PreparedStatement getUsers = conn.prepareStatement("SELECT * FROM users");
            ResultSet rs = getUsers.executeQuery();

            List<User> users = new ArrayList<>();

            while (rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String email = rs.getString("email");

                users.add(new User(id, firstName, lastName, email));
            }

            return users;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean registerUser(User user) {
        try {
            Connection conn = getDBConnection();
            PreparedStatement insert = conn.prepareStatement("INSERT INTO users(firstName, lastName, email) VALUES (?,?,?)");
            insert.setString(1, user.getFirstName());
            insert.setString(2, user.getLastName());
            insert.setString(3, user.getEmail());
            insert.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean updateUser(User user) {
        try {
            Connection conn = getDBConnection();
            PreparedStatement update = conn.prepareStatement("UPDATE users SET firstName=?, lastName=?, email=? WHERE id=?");
            update.setString(1, user.getFirstName());
            update.setString(2, user.getLastName());
            update.setString(3, user.getEmail());
            update.setInt(4, user.getId());
            update.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean deleteUser(int id) {
        try {
            Connection conn = getDBConnection();
            PreparedStatement delete = conn.prepareStatement("DELETE FROM users WHERE id=?");
            delete.setInt(1, id);
            delete.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
