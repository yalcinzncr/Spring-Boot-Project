package tr.gov.*****.*****essp*****.model.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import lombok.Getter;
import lombok.Setter;
import tr.gov.*****.*****essp*****.model.entity.reference.Kanal;
import tr.gov.*****.*****essp*****.model.entity.reference.KvkkPaylasim;
import tr.gov.*****.*****essp*****.model.entity.reference.SikayetDurum;

@Getter
@Setter
@Entity
@Table(name = "TSIKAYET", schema = "*****ESSP")
public class Sikayet extends BaseEntity {

  private static final long serialVersionUID = 1L;

  // e devlet servisinden gelecek.
  @Column(name = "TCKN")
  private String tckn;

  // sistem admin elle girecek.
  @Column(name = "VKN")
  private String vkn;

  // e devlet servisinden gelecek.
  @Column(name = "AD_SOYAD")
  private String adSoyad;

  // kullanici girecek.
  @Column(name = "E_POSTA")
  private String eposta;

  // kullanici girecek.
  @Column(name = "CEP_TEL", length = 10)
  private String ceptel;

  // kullanici girecek.
  @Column(name = "ADRES")
  private String adres;

  // kullanici bilgilerinin paylasmasini isterse.
  @Column(name = "KVKK_PAYLASIM", nullable = false)
  @Enumerated(EnumType.STRING)
  private KvkkPaylasim kvkkPaylasim;

  // auto generate edilecek.
  @Column(name = "BASVURU_NO", unique = true, nullable = false)
  private Integer basvuruNo;

  @Column(name = "DURUM", nullable = false)
  @Enumerated(EnumType.ORDINAL)
  private SikayetDurum durum;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "TUR_ID", nullable = false)
  private SikayetTur tur;
  
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ALT_KONU_ID", nullable = false)
  private SikayetAltKonu altKonu;
  
  @Column(name = "KANAL", nullable = false)
  @Enumerated(EnumType.ORDINAL)
  private Kanal kanal;

  @Column(name = "KANAL_NO")
  private String kanalNo;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "KONU_ID", nullable = false)
  private SikayetKonu konu;

  @Column(name = "METIN", nullable = false, length = 1000)
  private String metin;

  @Column(name = "BASVURU_TARIH", nullable = false)
  @Temporal(TemporalType.TIMESTAMP)
  private Date basvuruTarih;

  @Column(name = "CEVAP_TARIH")
  @Temporal(TemporalType.TIMESTAMP)
  private Date cevapTarih;

  @Column(name = "*****_CEVAP", length = 2000)
  private String *****Cevap;

  @Column(name = "BANKA_CEVAP", length = 2000)
  private String bankaCevap;
  
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "KURULUS_TUR_ID")
  private KurulusTur kurulusTur;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "KURULUS_ID")
  private Kurulus kurulus;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "DEGERLENDIRME_ID")
  private SikayetDegerlendirme degerlendirme;

  // sira no
  @Column(name = "ATANAN_KISI")
  private Integer atananKisi;

  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "sikayet", orphanRemoval = true)
  private List<SikayetNot> notlar = new ArrayList<>();

  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "sikayet", orphanRemoval = true)
  private List<SikayetLog> loglar = new ArrayList<>();

  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "sikayet", orphanRemoval = true)
  private List<SikayetDosya> dosyalar = new ArrayList<>();

  @Override
  public int hashCode() {
    return new HashCodeBuilder().appendSuper(super.hashCode()).append(this.tckn).append(this.vkn).append(this.adSoyad).append(this.eposta).append(this.ceptel)
        .append(this.adres).append(this.kvkkPaylasim).append(this.basvuruNo).append(this.durum).append(this.altKonu).append(this.tur).append(this.kanal).append(this.kanalNo).append(this.konu)
        .append(this.metin).append(this.basvuruTarih).append(this.cevapTarih).append(this.*****Cevap).append(this.kurulusTur).append(this.bankaCevap).append(this.kurulus)
        .append(this.degerlendirme).append(this.atananKisi).toHashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    final Sikayet other = (Sikayet) obj;
    return new EqualsBuilder().appendSuper(super.equals(obj)).append(this.tckn, other.tckn).append(this.vkn, other.vkn).append(this.adSoyad, other.adSoyad)
        .append(this.eposta, other.eposta).append(this.ceptel, other.ceptel).append(this.adres, other.adres).append(this.kvkkPaylasim, other.kvkkPaylasim)
        .append(this.basvuruNo, other.basvuruNo).append(this.durum, other.durum).append(this.kanal, other.kanal).append(this.kanalNo, other.kanalNo)
        .append(this.konu, other.konu).append(this.metin, other.metin).append(this.basvuruTarih, other.basvuruTarih).append(this.cevapTarih, other.cevapTarih)
        .append(this.*****Cevap, other.*****Cevap).append(this.bankaCevap, other.bankaCevap).append(this.kurulus, other.kurulus)
        .append(this.degerlendirme, other.degerlendirme).append(this.atananKisi, other.atananKisi).append(this.altKonu, other.altKonu).append(this.tur, other.tur).append(this.kurulusTur, other.kurulusTur).isEquals();
  }

}
