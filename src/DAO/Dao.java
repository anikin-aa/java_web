package DAO;


import Data.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Dao {
    private static final String URL = "jdbc:mysql://localhost:3306/db_first";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    public static List<User> Users = new ArrayList();
    private Connection connection;
    private Statement st;


    public List<User> getUsers() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            st = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql = "SELECT * FROM users";
        try {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Users.add(new User(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("surname"),
                        rs.getInt("age"), rs.getInt("passportNumber"), rs.getInt("passportSeries")));
            }
            rs.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return Users;
    }

    public void deleteUser(int id) {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            st = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String q = "DELETE from users where id =" + id;
        try {
            st.executeUpdate(q);
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public User getUserById(int id) {
        String q = "select id,name,surname,email,age,passportSeries,passportNumber from users where id=" + id;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            st = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ResultSet rs = st.executeQuery(q);
            if (rs.next()) {
                User user = new User(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("surname"),
                        rs.getInt("age"), rs.getInt("passportNumber"), rs.getInt("passportSeries"));
                return user;
            }
            rs.close();
        } catch (SQLException e) {
        }
        return null;
    }

    public void addUser(User p) {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            st = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String q = "insert into users (name,surname,email,age,passportSeries,passportNumber) values " + p.toString() + ";";
        try {
            st.executeUpdate(q);
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

}