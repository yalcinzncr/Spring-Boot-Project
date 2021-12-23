package tr.gov.*****.*****essp*****.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TSIKAYET_NOT", schema = "*****ESSP")
public class SikayetNot extends BaseEntity {

  private static final long serialVersionUID = 1L;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "SIKAYET_ID")
  private Sikayet sikayet;

  @Column(name = "METIN", length = 1000)
  private String metin;

  @Override
  public int hashCode() {
    return new HashCodeBuilder().appendSuper(super.hashCode()).append(this.sikayet).append(this.metin).toHashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    final SikayetNot other = (SikayetNot) obj;
    return new EqualsBuilder().appendSuper(super.equals(obj)).append(this.sikayet, other.sikayet).append(this.metin, other.metin).isEquals();
  }

}
