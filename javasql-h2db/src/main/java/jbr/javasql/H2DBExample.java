package jbr.javasql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.h2.tools.Server;

public class H2DBExample {
  String DRIVER = "org.h2.Driver";

  private void initServer() throws SQLException {
    Server server = Server.createTcpServer().start();
    System.out.println("Datbase is open.");
    System.out.println("URL: jdbc:h2:" + server.getURL() + "/mem:jbr");
    
    // 1. open cmd & enter:  java -jar C:\ranjiths\jbr\InstalledSofties\H2\bin\h2-1.4.192.jar
    // http://server:8082/login.jsp?jsessionid=01744b7260a0ece77057ec7ab4f69059 will be opened
    // 2. Enter jdbc:h2:tcp://server:49341/mem:jbr in JDBC URL and Connect - you can able to view the database
  }

  public void file() {
    Connection connection = null;
    ResultSet resultset = null;
    Statement statement = null;

    try {
      Class.forName(DRIVER);
      connection = DriverManager.getConnection("jdbc:h2:c:/ranjiths/jbr/InstalledSofties/h2db/db", "ranjith", "sekar");
      statement = connection.createStatement();
      resultset = statement.executeQuery("SELECT * FROM users");

      while (resultset.next()) {
        System.out.println("User Name: " + resultset.getString("FIRST_NAME") + " " + resultset.getString("LAST_NAME"));
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        resultset.close();
        statement.close();
        connection.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

  }

  private void inMemory() {
    Connection connection = null;
    ResultSet resultset = null;
    Statement statement = null;

    try {
      Class.forName(DRIVER);
      connection = DriverManager.getConnection("jdbc:h2:mem:jbr;DB_CLOSE_DELAY=-1", "", "");
      statement = connection.createStatement();
      statement.execute("CREATE TABLE books(book_id VARCHAR(30), book_name VARCHAR(30), authors VARCHAR(30), "
          + "publisher VARCHAR(30),price INTEGER)");
      statement.execute("INSERT INTO books VALUES('b100','Computer Science','John','TATA',400)");
      statement.execute("INSERT INTO books VALUES('b200','Mathematics','David','Oreilly',300)");
      statement.execute("INSERT INTO books VALUES('b300','Java Complete Reference','Jonathan','PSB',600)");

      resultset = statement.executeQuery("SELECT * FROM books");

      while (resultset.next()) {
        System.out
            .println("Book ID & Name: " + resultset.getString("book_id") + " " + resultset.getString("book_name"));
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        resultset.close();
        statement.close();
        connection.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

  }

  public static void main(String[] args) throws SQLException {
    H2DBExample h2dbExample = new H2DBExample();
    h2dbExample.initServer();
    h2dbExample.file();
    h2dbExample.inMemory();
  }
}
