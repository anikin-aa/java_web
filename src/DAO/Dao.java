package DAO;


import Data.User;
import com.sun.javafx.image.IntPixelGetter;
import com.sun.org.apache.regexp.internal.RESyntaxException;
import queriesAccess.QueryFinder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Dao {
    /*
    * need to remove username, pw from code add getting it from user???
    * */
    public static final String URL = "jdbc:mysql://localhost:3306/db_first";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "root";
    public static final String ERROR = "Something went wrong! ";
    public static List<User> Users = new ArrayList<>();
    private static Connection connection;
    private static PreparedStatement statement;
    private static Logger log = Logger.getLogger(QueryFinder.class.getName());


    static {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            log.log(Level.INFO, ERROR + e);
        }
    }

    public static List<User> getUsers() {
        try {
            statement =
                    connection.prepareStatement(QueryFinder.getQuery("get_all_users"));
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Users.add(new User(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("surname"),
                        rs.getString("position"),
                        rs.getInt("age"),
                        rs.getInt("salary")));
            }
        } catch (SQLException e) {
            log.log(Level.INFO, ERROR + e);
        } finally {
            handleConnection(connection);
        }
        return Users;
    }

    public static void deleteUser(int id) {
        try {
            statement = connection.prepareStatement(QueryFinder.getQuery("delete_user_by_id"));
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e) {
            log.log(Level.INFO, ERROR + e);
        } finally {
            handleConnection(connection);
        }
    }

    public static User getUserById(Integer id) {
        User user = null;
        try {
            statement = connection.prepareStatement(QueryFinder.getQuery("get_info_by_id"));
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                user = new User(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("surname"),
                        rs.getString("position"),
                        rs.getInt("age"),
                        rs.getInt("salary"));
            }
        } catch (SQLException e) {
            log.log(Level.INFO, ERROR + e);
        } finally {
            handleConnection(connection);
        }
        return user;
    }

    public static void addUser(User u) {
        if (u == null) {
            log.log(Level.WARNING, "Trying to add null user!");
            return;
        }
        try {
            statement = connection.prepareStatement(QueryFinder.getQuery("insert_user"));
            statement.setString(1, u.getName());
            statement.setString(2, u.getSurname());
            statement.setString(3, u.getEmail());
            statement.setInt(4, u.getAge());
            statement.setInt(5, u.getSalary());
            statement.setString(6, u.getPosition().toLowerCase());
            statement.execute();
            log.log(Level.INFO, "User added! " + u);
        } catch (SQLException e) {
            log.log(Level.INFO, ERROR + e);
        } finally {
            handleConnection(connection);
        }

    }

    public static void updateUser(User u) {
        if (u == null) {
            log.log(Level.INFO, "trying to update null user!");
            return;
        }
        try {
            Integer posId = getPositionIdByName(u.getPosition());
            statement = connection.prepareStatement(QueryFinder.getQuery("update_user_by_id"));
            statement.setString(1, u.getName());
            statement.setString(2, u.getSurname());
            statement.setString(3, u.getEmail());
            statement.setInt(4, u.getAge());
            statement.setInt(5, u.getSalary());
            statement.setInt(6, posId);
            statement.setInt(7, u.getId());
            statement.executeUpdate();
            log.log(Level.INFO, "User updated! " + u.getId());
        } catch (SQLException e) {
            log.log(Level.INFO, ERROR + e);
        } finally {
            handleConnection(connection);
        }
    }

    private static Integer getPositionIdByName(String name) throws SQLException {
        if (name == null) {
            return null;
        }
        statement = connection.prepareStatement(QueryFinder.getQuery("get_pos_id_by_name"));
        statement.setString(1, name.toLowerCase());
        ResultSet rs = statement.executeQuery();
        Integer id = null;
        while (rs.next()) {
            id = rs.getInt(1);
        }
        return id;
    }

    private static void handleConnection(Connection connection) {
        try {
            if (statement != null)
                connection.close();
            if (connection != null)
                connection.close();
        } catch (SQLException e) {
            System.out.println(ERROR + e);
        }
    }
}