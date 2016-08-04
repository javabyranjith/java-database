package jbr.h2db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class H2DBExample {
  public static void main(String[] args) {
    Connection connection = null;
    ResultSet resultSet = null;
    Statement statement = null;
    String URL = "jdbc:h2:c:/ranjiths/jbr/InstalledSofties/h2db/db";
    String username = "ranjith";
    String password = "sekar";

    try {
      Class.forName("org.h2.Driver");
      connection = DriverManager.getConnection(URL, username, password);
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
