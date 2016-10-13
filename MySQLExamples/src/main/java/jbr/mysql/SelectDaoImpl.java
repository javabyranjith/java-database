package jbr.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jbr.mysql.model.EmpInfo;
import jbr.mysql.util.MySQLUtil;

public class SelectDaoImpl implements SelectDao {

  @Override
  public List<EmpInfo> getAllEmployees() {
    List<EmpInfo> employees = new ArrayList<EmpInfo>();

    Connection conn = MySQLUtil.getConnection();
    Statement statement = null;
    ResultSet resultset = null;

    try {
      statement = conn.createStatement();
      resultset = statement.executeQuery("select * from empinfo");

      while (resultset.next()) {
        EmpInfo empInfo = new EmpInfo();

        empInfo.setEmpId(resultset.getInt("empid"));
        empInfo.setFirstname(resultset.getString("firstname"));
        empInfo.setLastname(resultset.getString("lastname"));
        empInfo.setDob(resultset.getDate("dob"));
        empInfo.setDesignation(resultset.getString("designation"));
        empInfo.setDoj(resultset.getDate("doj"));

        employees.add(empInfo);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      if (null != resultset) try {
        resultset.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
      if (null != statement) try {
        statement.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
      if (null != conn) try {
        conn.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }

    return employees;
  }

}
