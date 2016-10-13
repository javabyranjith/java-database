package jbr.mysql.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLUtil {

  public static Connection getConnection() {
    Connection conn = null;
    String dbName = "jdbc:mysql://localhost:3306/employee";
    String username = "root";
    String password = "root";

    // Register JDBC Driver
    try {
      Class.forName("com.mysql.jdbc.Driver");
      conn = DriverManager.getConnection(dbName, username, password);
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }

    return conn;
  }

}
