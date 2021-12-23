package tr.gov.*****.*****essp*****.config;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.stereotype.Component;
import tr.gov.*****.*****essp*****.interceptor.EntityInterceptor;

@Component
public class HibernateInterceptorConfig implements HibernatePropertiesCustomizer {

  private @Autowired EntityInterceptor entityInterceptor;

  @Override
  public void customize(Map<String, Object> hibernateProperties) {
    hibernateProperties.put("hibernate.session_factory.interceptor", entityInterceptor);
  }

}
