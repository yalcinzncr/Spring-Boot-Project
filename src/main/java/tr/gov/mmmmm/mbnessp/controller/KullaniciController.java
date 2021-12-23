package tr.gov.*****.*****essp*****.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.gov.*****.*****essp*****.model.dto.EDSKullanici;
import tr.gov.*****.*****essp*****.service.sam.SamUserService;

@RestController
@RequestMapping("/kullanici")
public class KullaniciController extends BaseController {

  private @Autowired SamUserService samUserService;

  @GetMapping
  public EDSKullanici getKullanici() {
    return samUserService.getKullanici();
  }

}
