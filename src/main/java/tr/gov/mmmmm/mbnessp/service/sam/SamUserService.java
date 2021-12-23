package tr.gov.*****.*****essp*****.service.sam;

import java.io.Serializable;
import tr.gov.*****.*****essp*****.model.dto.EDSKullanici;

public interface SamUserService extends Serializable {

  public EDSKullanici getKullanici();

}
