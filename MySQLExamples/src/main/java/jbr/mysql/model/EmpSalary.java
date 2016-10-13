package jbr.mysql.model;

public class EmpSalary {
  private Integer empId;
  private Double basic;
  private Double hra;
  private Double allowance;
  private Double deduction;

  public Integer getEmpId() {
    return empId;
  }

  public void setEmpId(Integer empId) {
    this.empId = empId;
  }

  public Double getBasic() {
    return basic;
  }

  public void setBasic(Double basic) {
    this.basic = basic;
  }

  public Double getHra() {
    return hra;
  }

  public void setHra(Double hra) {
    this.hra = hra;
  }

  public Double getAllowance() {
    return allowance;
  }

  public void setAllowance(Double allowance) {
    this.allowance = allowance;
  }

  public Double getDeduction() {
    return deduction;
  }

  public void setDeduction(Double deduction) {
    this.deduction = deduction;
  }

}
