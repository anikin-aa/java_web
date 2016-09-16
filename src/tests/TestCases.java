package tests;

import org.junit.BeforeClass;
import queriesAccess.QueryFinder;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static DAO.Dao.PASSWORD;
import static DAO.Dao.URL;
import static DAO.Dao.USERNAME;
import static org.junit.Assert.*;

public class TestCases {
    private static Connection connection;
    private final String DB_NAME = "db_first";
    private final String USERS = "users";
    private final String USER_POS = "user_positions";
    List<String> tables_test = Arrays.asList(USER_POS, USERS);

    /*
    * Create connect with DB
    * */
    @BeforeClass
    public static void createConnect() throws SQLException {
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    @Test
    public void checkForNull() {
        assertNull(QueryFinder.getQuery(null));
    }

    @Test
    public void checkForString() {
        assertEquals("1", QueryFinder.getQuery("test"));
    }

    @Test(expected = Error.class)
    public void fileNotFound() {
        QueryFinder.getQuery("test.txt");
    }

    @Test
    public void checkForConnect() throws SQLException {
        assertNotNull(connection);
    }

    @Test(expected = SQLException.class)
    public void checkForWrongConnect() throws SQLException {
        DriverManager.getConnection(URL, "asdzxc", PASSWORD);
    }

    @Test
    public void dbExists() throws SQLException {
        ResultSet rs = connection.getMetaData().getCatalogs();
        boolean flag = false;
        while (rs.next()) {
            if (DB_NAME.equals(rs.getString(1))) {
                flag = true;
                break;
            }
        }
        assertTrue(flag);
    }

    //pretty bad test cuz position of elements matter too
    @Test
    public void tablesExists() throws SQLException {
        ResultSet rs = connection.getMetaData().getTables(DB_NAME, null, "%", null);
        List<String> tables = new ArrayList<>();
        while (rs.next()) {
            tables.add(rs.getString(3));
        }
        assertEquals(tables, tables_test);
    }
}
