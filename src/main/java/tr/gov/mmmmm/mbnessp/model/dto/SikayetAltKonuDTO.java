package tr.gov.*****.*****essp*****.model.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import tr.gov.*****.*****essp*****.model.entity.reference.AktifPasif;

@Getter
@Setter
public class SikayetAltKonuDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long id;
  
  @NotNull(message = "ad boş olamaz", groups = { VMInterface.SikayetAltKonuGuncelle.class })
  private String ad;
  
  @NotNull(message = "altif pasif boş olamaz", groups = { VMInterface.SikayetAltKonuGuncelle.class })
  private AktifPasif aktifPasif;
  
  private SikayetKonuDTO konu;

}
