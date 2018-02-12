package myDemoApp.repository;

import java.util.List;
import myDemoApp.model.User;
import org.springframework.data.repository.CrudRepository;

public abstract interface UserRepository
  extends CrudRepository<User, Integer>
{
  public abstract User findById(Integer paramInteger);
  
  public abstract List<User> findByFirstName(String paramString);
  
  public abstract List<User> findByLastName(String paramString);
  
  public abstract List<User> findByFirstNameAndLastName(String paramString1, String paramString2);
  
  public abstract User save(User paramUser);
  
  public abstract void delete(User paramUser);
}