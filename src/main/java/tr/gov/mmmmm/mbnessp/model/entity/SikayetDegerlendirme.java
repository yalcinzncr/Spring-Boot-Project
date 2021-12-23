package tr.gov.*****.*****essp*****.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import lombok.Getter;
import lombok.Setter;
import tr.gov.*****.*****essp*****.model.entity.reference.AktifPasif;

@Getter
@Setter
@Entity
@Table(name = "TSIKAYET_DEGERLENDIRME", schema = "*****ESSP")
public class SikayetDegerlendirme extends BaseEntity {

  private static final long serialVersionUID = 1L;

  @Column(name = "AD")
  private String ad;

  @Column(name = "AKTIF_FLAG")
  @Enumerated(EnumType.STRING)
  private AktifPasif aktifPasif;

  @Override
  public int hashCode() {
    return new HashCodeBuilder().appendSuper(super.hashCode()).append(this.ad).append(this.aktifPasif).toHashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    final SikayetDegerlendirme other = (SikayetDegerlendirme) obj;
    return new EqualsBuilder().appendSuper(super.equals(obj)).append(this.ad, other.ad).append(this.aktifPasif, other.aktifPasif).isEquals();
  }

}
