package tr.gov.*****.*****essp*****.model.dto;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import tr.gov.*****.*****essp*****.model.entity.reference.Kanal;
import tr.gov.*****.*****essp*****.model.entity.reference.KvkkPaylasim;
import tr.gov.*****.*****essp*****.model.entity.reference.SikayetDurum;

@Getter
@Setter
@ToString
public class SikayetDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long id;

  @NotNull(message = "TCKN boş olamaz!", groups = { VMInterface.SikayetGuncelle.class })
  private String tckn;

  private String vkn;

  @NotNull(message = "Ad soyad boş olamaz!", groups = { VMInterface.SikayetGuncelle.class })
  private String adSoyad;

  @NotNull(message = "E-posta boş olamaz!", groups = { VMInterface.SikayetGuncelle.class })
  private String eposta;

  @NotNull(message = "Cep telefonu boş olamaz!", groups = { VMInterface.SikayetGuncelle.class })
  private String ceptel;

  @NotNull(message = "Adres boş olamaz!", groups = { VMInterface.SikayetGuncelle.class })
  private String adres;

  @NotNull(message = "Kvkk paylaşımı boş olamaz!", groups = { VMInterface.SikayetGuncelle.class })
  private KvkkPaylasim kvkkPaylasim;

  private Integer basvuruNo;

  private SikayetDurum durum;
  
  @NotNull(message = "Sikayet tur boş olamaz!", groups = { VMInterface.SikayetGuncelle.class })
  private SikayetTurDTO tur;

  private Kanal kanal;

  private String kanalNo;

  @NotNull(message = "Konu boş olamaz!", groups = { VMInterface.SikayetGuncelle.class })
  private SikayetKonuDTO konu;

  @NotNull(message = "Alt konu boş olamaz!", groups = { VMInterface.SikayetGuncelle.class })
  private SikayetAltKonuDTO altKonu;

  @NotNull(message = "metin boş olamaz!", groups = { VMInterface.SikayetGuncelle.class })
  private String metin;

  private Date basvuruTarih;

  private Date cevapTarih;

  private String *****Cevap;

  private String bankaCevap;
  
  @NotNull(message = "Kurulus tur boş olamaz!", groups = { VMInterface.SikayetGuncelle.class })
  private KurulusTurDTO kurulusTur;

  @NotNull(message = "Kurulus boş olamaz!", groups = { VMInterface.SikayetGuncelle.class })
  private KurulusDTO kurulus;

  private Integer atananKisi;


}