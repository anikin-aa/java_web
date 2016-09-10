package DAO;


import Data.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Dao {
    public static final String URL = "jdbc:mysql://localhost:3306/db_first";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "root";
    public List<User> Users = new ArrayList();
    private Connection connection;
    private Statement st;

    public Dao() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

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
                Users.add(new User(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("surname"), rs.getString("position"),
                        rs.getInt("age"), rs.getInt("passportNumber"), rs.getInt("passportSeries"), rs.getInt("salary")));
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
                if (connection != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public User getUserById(int id) {
        String q = "select * from users where id=" + id;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            st = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ResultSet rs = st.executeQuery(q);
            if (rs.next()) {
                User user = new User(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("surname"), rs.getString("position"),
                        rs.getInt("age"), rs.getInt("passportNumber"), rs.getInt("passportSeries"), rs.getInt("salary"));
                return user;
            }
            rs.close();
        } catch (SQLException e) {
        }
        return null;
    }

    public void addUser(User u) {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            st = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String q = "insert into users (name,surname,email,position,age,passportSeries,passportNumber,salary) values " + u.toString() + ";";
        try {
            st.executeUpdate(q);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null)
                    connection.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public void updateUser(User u) {
        String q = "Update users set name ='" + u.getName() + "',surname='" + u.getSurname() + "',email='" + u.getEmail() + "',salary='" + u.getSalary() +
                "',age=" + u.getAge() + ",passportSeries='" + u.getpassSeries() + "',passportNumber='" + u.getpassNumb() + "',POSITION ='" + u.getPosition() + "' where id=" + u.getId();
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            st = connection.createStatement();
            st.executeUpdate(q);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null)
                    connection.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }


}