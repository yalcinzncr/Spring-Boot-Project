package tr.gov.*****.*****essp*****.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import tr.gov.*****.*****essp*****.service.sam.SamDummyUserServiceImpl;
import tr.gov.*****.*****essp*****.service.sam.SamUserService;
import tr.gov.*****.*****essp*****.service.sam.SamUserServiceImpl;

@Configuration
@ComponentScan("tr.gov.*****.security")
public class SecurityConfig {

  @Profile({"default"})
  @Bean(name = "samUserService")
  public SamUserService samUserService() {
    return new SamUserServiceImpl();
  }

  @Profile({"local"})
  @Bean(name = "samUserService")
  public SamUserService samDummyUserService() {
    return new SamDummyUserServiceImpl();
  }

}
