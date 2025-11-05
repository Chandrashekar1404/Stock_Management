package Db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/stock_system";
    private static final String USER = "root";
    private static final String PASSWORD = "Chandra30071";

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Database connection successful!");
        }
        catch (ClassNotFoundException e) {
            System.out.println("❌ JDBC Driver not found! Make sure MySQL Connector JAR is added.");
            e.printStackTrace();
        }
        catch (SQLException e) {
            System.out.println("❌ SQL Exception: " + e.getMessage());
            e.printStackTrace();
        }
        catch (Exception e) {
            System.out.println("❌ Unexpected Error: " + e.getMessage());
            e.printStackTrace();
        }
        return con;
    }
}
