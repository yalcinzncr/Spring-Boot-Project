package tr.gov.*****.*****essp*****.controller;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

public class BaseController {

  private static final String[] DISALLOWED_FIELDS = new String[] {"FORTIFY"};

  @InitBinder
  public void initBinder(WebDataBinder binder) {
    binder.setDisallowedFields(DISALLOWED_FIELDS);
  }

}
