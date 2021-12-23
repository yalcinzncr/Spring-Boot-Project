package tr.gov.*****.*****essp*****.model.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import tr.gov.*****.*****essp*****.model.entity.reference.AktifPasif;

@Getter
@Setter
public class SikayetSablonDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long id;
    
  @NotNull(message = "altif pasif boş olamaz", groups = { VMInterface.SikayetSablonGuncelle.class })
  private AktifPasif aktifPasif;
  
  private String metin;
  
  private SikayetKonuDTO konu;
  
  private SikayetAltKonuDTO altKonu;
  
  private SikayetTurDTO tur;

}
