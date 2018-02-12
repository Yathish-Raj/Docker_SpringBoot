package myDemoApp.model;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TUSER")
public class User
{
  @Id
  @GeneratedValue
  @Column(name="USER_ID")
  private Integer id;
  
  @Column(name="FIRST_NAME")
  private String firstName;
  
  @Column(name="LAST_NAME")
  private String lastName;
  
  @Column(name="DATE_OF_BIRTH")
  private Date dateOfBirth;
  
  @Column(name="GENDER")
  private String gender;
  
  public User() {}
  
  public Integer getId()
  {
    return id;
  }
  
  public void setId(Integer id) {
    this.id = id;
  }
  
  public String getFirstName() {
    return firstName;
  }
  
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }
  
  public String getLastName() {
    return lastName;
  }
  
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
  
  public Date getDateOfBirth() {
    return dateOfBirth;
  }
  
  public void setDateOfBirth(Date dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }
  
  public String getGender() {
    return gender;
  }
  
  public void setGender(String gender) {
    this.gender = gender;
  }
}