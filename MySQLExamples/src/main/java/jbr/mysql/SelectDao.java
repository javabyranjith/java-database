package jbr.mysql;

import java.util.List;

import jbr.mysql.model.EmpInfo;

public interface SelectDao {

  List<EmpInfo> getAllEmployees();
}
