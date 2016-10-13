package jbr.mysql;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import jbr.mysql.model.EmpInfo;

public class SelectDaoImplTest {
  private SelectDao selectDao;

  @Before
  public void setUp() throws Exception {
    selectDao = new SelectDaoImpl();
  }

  @Test
  public void testGetAllEmployees() {
    List<EmpInfo> emps = selectDao.getAllEmployees();
    
    for(EmpInfo e: emps){
      System.out.println("Firstname: "+ e.getFirstname());
    }
  }

}
