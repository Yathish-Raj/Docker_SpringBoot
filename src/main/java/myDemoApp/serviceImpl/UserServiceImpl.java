package myDemoApp.serviceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import myDemoApp.model.User;
import myDemoApp.repository.UserRepository;
import myDemoApp.service.UserService;
import myDemoApp.vo.UserDetailsVO;
import myDemoApp.vo.UserLoginDetailsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class UserServiceImpl
  implements UserService
{
  @Autowired
  UserRepository userRepository;
  
  public UserServiceImpl() {}
  
  public List<UserLoginDetailsVO> saveUserDetails(UserDetailsVO userDetails)
  {
    UserLoginDetailsVO userLoginDetails = new UserLoginDetailsVO();
    List<UserLoginDetailsVO> userLoginDetailsList = new ArrayList<UserLoginDetailsVO>();
    User inUser = new User();User outUser = new User();
    if (userDetails != null) {
      userLoginDetailsList = getSavedUserDetails(userDetails.getFirstName(), userDetails.getLastName());
      if ((userLoginDetailsList != null) && (!userLoginDetailsList.isEmpty())) {
        return userLoginDetailsList;
      }
      inUser.setFirstName(userDetails.getFirstName());
      inUser.setLastName(userDetails.getLastName());
      try
      {
        if (userDetails.getDob() != null) {
          String dob = userDetails.getDob().substring(0, 10);
          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
          java.util.Date date = sdf.parse(dob);
          java.sql.Date sqlDob = new java.sql.Date(date.getTime());
          inUser.setDateOfBirth(sqlDob);
        }
      }
      catch (ParseException ex) {
        ex.printStackTrace();
      }
      
      inUser.setGender(userDetails.getGender());
      
      outUser = userRepository.save(inUser);
      if (outUser != null) {
        userLoginDetails.setId(outUser.getId());
        userLoginDetails.setFirstName(outUser.getFirstName());
        userLoginDetails.setLastName(outUser.getLastName());
        userLoginDetails.setDob(outUser.getDateOfBirth() != null ? new java.util.Date(outUser.getDateOfBirth().getTime()) : null);
        userLoginDetails.setGender(outUser.getGender());
        
        userLoginDetailsList.add(userLoginDetails);
      }
    }
    
    return userLoginDetailsList;
  }
  

  public List<UserLoginDetailsVO> getSavedUserDetails(String firstName, String lastName)
  {
    List<UserLoginDetailsVO> userLoginDetailsList = new ArrayList<UserLoginDetailsVO>();
    List<User> outUserList = new ArrayList<User>();
    if ((firstName != null) && (!firstName.isEmpty()) && (lastName != null) && (!lastName.isEmpty())) {
      outUserList = userRepository.findByFirstNameAndLastName(firstName, lastName);
    }
    else if ((firstName != null) && (!firstName.isEmpty()) && ((lastName == null) || (lastName.isEmpty()))) {
      outUserList = userRepository.findByFirstName(firstName);
    }
    else if (((firstName == null) || (firstName.isEmpty())) && (lastName != null) && (!lastName.isEmpty())) {
      outUserList = userRepository.findByLastName(lastName);
    }
    if (outUserList != null) {
      for (User outUser : outUserList) {
        UserLoginDetailsVO userLoginDetails = new UserLoginDetailsVO();
        userLoginDetails.setId(outUser.getId());
        userLoginDetails.setFirstName(outUser.getFirstName());
        userLoginDetails.setLastName(outUser.getLastName());
        userLoginDetails.setDob(outUser.getDateOfBirth() != null ? new java.util.Date(outUser.getDateOfBirth().getTime()) : null);
        userLoginDetails.setGender(outUser.getGender());
        userLoginDetails.setPresentInDb(true);
        
        userLoginDetailsList.add(userLoginDetails);
      }
    }
    return userLoginDetailsList;
  }
}