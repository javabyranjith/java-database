package jbr.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jbr.mysql.util.MySQLUtil;

public class SelectExample {

  public static void main(String[] args) throws SQLException {

    Connection conn = MySQLUtil.getConnection();
    Statement stmt = null;
    ResultSet rs = null;
    try {
      stmt = conn.createStatement();
      rs = stmt.executeQuery("select * from empinfo");
      while (rs.next()) {
        System.out.println(rs.getString(1)); // empid
        System.out.println(rs.getString(2)); // firstname

        // get by column name
        System.out.println(rs.getString("lastname") + "\n");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      if (null != rs) rs.close();
      if (null != stmt) stmt.close();
      if (null != conn) conn.close();
    }

  }
}
