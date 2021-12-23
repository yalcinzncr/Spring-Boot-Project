package tr.gov.*****.*****essp*****.model.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import tr.gov.*****.*****essp*****.model.entity.reference.AktifPasif;
import tr.gov.*****.*****essp*****.model.entity.reference.BankaKullaniciRol;

@Getter
@Setter
public class BankaKullaniciDTO implements Serializable {

  private static final long serialVersionUID = 1L;
  
  private Long id;
  
  @NotNull(message = "ad soyad boş olamaz", groups = { VMInterface.BankaKullaniciGuncelle.class })
  private String adSoyad;
    
  @NotNull(message = "altif pasif boş olamaz", groups = { VMInterface.BankaKullaniciGuncelle.class })
  private AktifPasif aktifPasif;
  
  private String birim;
  
  private String cepTel;
  
  @NotNull(message = "ePosta boş olamaz", groups = { VMInterface.BankaKullaniciGuncelle.class })
  private String eposta;
  
  @NotNull(message = "rol boş olamaz", groups = { VMInterface.BankaKullaniciGuncelle.class })
  private BankaKullaniciRol rol;
  
  private String sifre;
  
  private String telefon;
  
  private String unvan;
  
  private KurulusDTO kurulus;
 
}
