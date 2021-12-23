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
import tr.gov.*****.*****essp*****.model.entity.reference.KullaniciRol;

@Getter
@Setter
@Entity
@Table(name = "TKULLANICI", schema = "*****ESSP")
public class Kullanici extends BaseEntity {

  private static final long serialVersionUID = 1L;

  @Column(name = "SIRA_NO", nullable = false, unique = true)
  private Integer siraNo;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "MUDURLUK_ID")
  private Mudurluk mudurluk;

  @Column(name = "ROL")
  @Enumerated(EnumType.STRING)
  private KullaniciRol rol;

  @Column(name = "ATANAN_TOPLAM_SIKAYET")
  private Integer atananToplamSikayet = Integer.decode("0");

  @Column(name = "AKTIF_FLAG")
  @Enumerated(EnumType.STRING)
  private AktifPasif aktifPasif;

  @Override
  public int hashCode() {
    return new HashCodeBuilder().appendSuper(super.hashCode()).append(this.siraNo).append(this.mudurluk).append(this.rol).toHashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    final Kullanici other = (Kullanici) obj;
    return new EqualsBuilder().appendSuper(super.equals(obj)).append(this.siraNo, other.siraNo).append(this.mudurluk, other.mudurluk)
        .append(this.rol, other.rol).isEquals();
  }

}
