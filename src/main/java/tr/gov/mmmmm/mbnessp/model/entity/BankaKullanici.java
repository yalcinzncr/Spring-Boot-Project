package tr.gov.*****.*****essp*****.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import lombok.Getter;
import lombok.Setter;
import tr.gov.*****.*****essp*****.model.entity.reference.AktifPasif;
import tr.gov.*****.*****essp*****.model.entity.reference.BankaKullaniciRol;

@Getter
@Setter
@Entity
@Table(name = "TBANKA_KULLANICI", schema = "*****ESSP")
public class BankaKullanici extends BaseEntity {

  private static final long serialVersionUID = 1L;

  @Column(name = "AD_SOYAD")
  private String adSoyad;

  @Column(name = "SIFRE")
  private String sifre;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "KURULUS_ID")
  private Kurulus kurulus;

  @Column(name = "BIRIM")
  private String birim;

  @Column(name = "UNVAN")
  private String unvan;

  @Column(name = "E_POSTA")
  private String eposta;

  @Column(name = "TELEFON")
  private String telefon;

  @Column(name = "CEP_TEL")
  private String cepTel;

  @Column(name = "ROL", nullable = false)
  @Enumerated(EnumType.STRING)
  private BankaKullaniciRol rol;

  @Column(name = "AKTIF_FLAG")
  @Enumerated(EnumType.STRING)
  private AktifPasif aktifPasif;

  @Override
  public int hashCode() {
    return new HashCodeBuilder().appendSuper(super.hashCode()).append(this.adSoyad).append(this.sifre).append(this.kurulus).append(this.birim)
        .append(this.unvan).append(this.eposta).append(this.telefon).append(this.cepTel).append(this.rol).append(this.aktifPasif).toHashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    final BankaKullanici other = (BankaKullanici) obj;
    return new EqualsBuilder().appendSuper(super.equals(obj)).append(this.adSoyad, other.adSoyad).append(this.sifre, other.sifre)
        .append(this.kurulus, other.kurulus).append(this.birim, other.birim).append(this.unvan, other.unvan).append(this.eposta, other.eposta)
        .append(this.telefon, other.telefon).append(this.cepTel, other.cepTel).append(this.rol, other.rol).append(this.aktifPasif, other.aktifPasif).isEquals();
  }

}
