package myDemoApp.controller;

import java.util.ArrayList;
import java.util.List;
import myDemoApp.service.UserService;
import myDemoApp.vo.UserDetailsVO;
import myDemoApp.vo.UserLoginDetailsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/demouserapp/*"})
public class DashboardController
{
  @Autowired
  UserService userService;
  
  public DashboardController() {}
  
  @PostMapping(value={"/saveuser"}, produces={"application/json"})
  public List<UserLoginDetailsVO> saveUser(@RequestBody UserDetailsVO userDetails)
  {
    List<UserLoginDetailsVO> loginDetails = new ArrayList<UserLoginDetailsVO>();
    loginDetails = userService.saveUserDetails(userDetails);
    
    return loginDetails;
  }
  

  @GetMapping(value={"/getuser"}, produces={"application/json"})
  public List<UserLoginDetailsVO> getUser(@RequestParam(value="firstname", required=false) String firstName, 
		  @RequestParam(value="lastname", required=false) String lastName)
  {
    List<UserLoginDetailsVO> loginDetailsList = new ArrayList<UserLoginDetailsVO>();
    loginDetailsList = userService.getSavedUserDetails(firstName, lastName);
    
    return loginDetailsList;
  }
}