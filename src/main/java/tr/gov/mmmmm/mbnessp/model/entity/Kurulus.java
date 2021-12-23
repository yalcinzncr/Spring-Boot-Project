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

@Getter
@Setter
@Entity
@Table(name = "TKURULUS", schema = "*****ESSP")
public class Kurulus extends BaseEntity {

  private static final long serialVersionUID = 1L;

  @Column(name = "AD", nullable = false)
  private String ad;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "KURULUS_TUR_ID", nullable = false)
  private KurulusTur tur;

  @Column(name = "AKTIF_FLAG")
  @Enumerated(EnumType.STRING)
  private AktifPasif aktifPasif;

  @Override
  public int hashCode() {
    return new HashCodeBuilder().appendSuper(super.hashCode()).append(this.ad).append(this.tur).append(this.aktifPasif).toHashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    final Kurulus other = (Kurulus) obj;
    return new EqualsBuilder().appendSuper(super.equals(obj)).append(this.ad, other.ad).append(this.tur, other.tur).append(this.aktifPasif, other.aktifPasif)
        .isEquals();
  }

}
