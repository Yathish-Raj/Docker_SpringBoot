package myDemoApp.service;

import java.util.List;
import myDemoApp.vo.UserDetailsVO;
import myDemoApp.vo.UserLoginDetailsVO;

public abstract interface UserService
{
  public abstract List<UserLoginDetailsVO> saveUserDetails(UserDetailsVO paramUserDetailsVO);
  
  public abstract List<UserLoginDetailsVO> getSavedUserDetails(String paramString1, String paramString2);
}