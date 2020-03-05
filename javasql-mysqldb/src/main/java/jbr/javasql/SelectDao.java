package jbr.javasql;

import java.util.List;

import jbr.javasql.model.EmpInfo;

public interface SelectDao {

  List<EmpInfo> getAllEmployees();
}
