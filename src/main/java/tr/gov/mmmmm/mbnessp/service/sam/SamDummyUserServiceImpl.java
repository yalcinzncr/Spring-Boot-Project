package tr.gov.*****.*****essp*****.service.sam;

import java.io.Serializable;
import java.util.Arrays;
import org.springframework.stereotype.Component;
import tr.gov.*****.*****essp*****.model.dto.EDSKullanici;

@Component
public class SamDummyUserServiceImpl implements SamUserService, Serializable {

  private static final long serialVersionUID = 1L;

  @Override
  public EDSKullanici getKullanici() {

    EDSKullanici kullanici = new EDSKullanici();

    kullanici.setAdSoyad("Yalçın Zencirkıran");
    kullanici.setUnvan("Dış Kaynak");
    kullanici.setSiraNo(Integer.valueOf(14979));
    kullanici.setRoller(Arrays.asList("UYG_*****ESSP_ADMIN"));

    return kullanici;

  }

}
