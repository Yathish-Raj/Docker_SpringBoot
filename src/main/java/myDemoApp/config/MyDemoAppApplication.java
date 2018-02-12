package myDemoApp.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages={"myDemoApp.*"})
@EntityScan({"myDemoApp.model"})
@EnableJpaRepositories({"myDemoApp.repository"})
public class MyDemoAppApplication extends SpringBootServletInitializer
{
  public MyDemoAppApplication() {}
  
  public static void main(String[] args)
  {
    SpringApplication.run(MyDemoAppApplication.class, args);
  }
}