package tr.gov.*****.*****essp*****.model.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import tr.gov.*****.*****essp*****.model.entity.reference.AktifPasif;

@Getter
@Setter
public class DuyuruDTO implements Serializable {

  private static final long serialVersionUID = 1L;
  
  private Long id;
  
  @NotNull(message = "baslik boş olamaz", groups = { VMInterface.DuyuruGuncelle.class })
  private String baslik;
  
  @NotNull(message = "icerik boş olamaz", groups = { VMInterface.DuyuruGuncelle.class })
  private String icerik;
  
  @NotNull(message = "altif pasif boş olamaz", groups = { VMInterface.DuyuruGuncelle.class })
  private AktifPasif aktifPasif;
  

}
