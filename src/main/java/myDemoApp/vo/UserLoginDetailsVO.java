package myDemoApp.vo;

import java.util.Date;

public class UserLoginDetailsVO {
  private Integer id;
  private String firstName;
  private String lastName;
  private Date dob;
  private String gender;
  boolean isPresentInDb;
  
  public UserLoginDetailsVO() {}
  
  public Integer getId() {
    return id;
  }
  
  public void setId(Integer id) { this.id = id; }
  
  public String getFirstName() {
    return firstName;
  }
  
  public void setFirstName(String firstName) { this.firstName = firstName; }
  
  public String getLastName() {
    return lastName;
  }
  
  public void setLastName(String lastName) { this.lastName = lastName; }
  
  public Date getDob() {
    return dob;
  }
  
  public void setDob(Date dob) { this.dob = dob; }
  
  public String getGender() {
    return gender;
  }
  
  public void setGender(String gender) { this.gender = gender; }
  
  public boolean isPresentInDb() {
    return isPresentInDb;
  }
  
  public void setPresentInDb(boolean isPresentInDb) { this.isPresentInDb = isPresentInDb; }
}
