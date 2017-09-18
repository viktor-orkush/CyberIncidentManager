package Databases;

import javax.naming.NamingException;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MySQLClassDB {
    // JDBC URL, username and password of MySQL server
    private static final String url = "jdbc:mysql://localhost/ckb";
    private static final String user = "root";
    private static final String password = "";

    private static final String TABLE_INCIDENT = "incident";

    public static Connection conn;
    public static Statement stat;
    public static ResultSet rs;

    public static Connection Conn () throws ClassNotFoundException, SQLException, IllegalAccessException, InstantiationException {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        conn = DriverManager.getConnection(url, user, password);
        System.out.println("CONNECT !!!!!!");
        return conn;
    }


    public static void CloseDB() throws ClassNotFoundException, SQLException {
        conn.close();
    }

    public static void addName(String name) throws ClassNotFoundException, SQLException {
        try {
            Conn();
            stat = conn.createStatement();
            PreparedStatement statement = conn.prepareStatement("INSERT INTO " + TABLE_INCIDENT + " (name) VALUES (?)");
            statement.setString(1, name);
            statement.execute();
            statement.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        finally {
            stat.close();
            CloseDB();
        }
    }

    public static ArrayList<String> getAllNames() throws ClassNotFoundException, SQLException, NamingException
    {
        ArrayList<String> names = new ArrayList<String>();

        try {
            Conn();
            stat = conn.createStatement();
            ResultSet rs = stat.executeQuery("select name from " + TABLE_INCIDENT);

            while (rs.next()) {
                names.add(rs.getString("name"));
            }
            rs.close();
            stat.close();
            CloseDB();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return names;
    }
}
