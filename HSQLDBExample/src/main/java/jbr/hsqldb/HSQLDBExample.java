package jbr.hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class HSQLDBExample {
  public static void main(String[] args) {
    Connection connection = null;
    ResultSet resultSet = null;
    Statement statement = null;

    try {
      Class.forName("org.hsqldb.jdbcDriver");
      connection = DriverManager.getConnection("jdbc:hsqldb:file:c:/ranjiths/jbr/hsqldb/db", "ranjith", "sekar");
      statement = connection.createStatement();
      resultSet = statement.executeQuery("SELECT * FROM users");

      while (resultSet.next()) {
        System.out.println("User Name: " + resultSet.getString("FIRST_NAME") + " " + resultSet.getString("LAST_NAME"));
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        resultSet.close();
        statement.close();
        connection.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}
