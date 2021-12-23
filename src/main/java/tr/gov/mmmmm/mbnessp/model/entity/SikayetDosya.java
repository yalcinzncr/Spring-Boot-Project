package tr.gov.*****.*****essp*****.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import lombok.Getter;
import lombok.Setter;
import tr.gov.*****.*****essp*****.model.entity.reference.DosyaTur;

@Getter
@Setter
@Entity
@Table(name = "TSIKAYET_DOSYA", schema = "*****ESSP")
public class SikayetDosya extends BaseEntity {

  private static final long serialVersionUID = 1L;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "SIKAYET_ID")
  private Sikayet sikayet;

  @Column(name = "AD", length = 200, nullable = false)
  private String ad;

  @Column(name = "UZANTI_AD", length = 200, nullable = false)
  private String uzantiAd;

  @Lob
  @Column(name = "VERI", length = 5242880)
  private byte[] veri;

  @Column(name = "TUR")
  @Enumerated(EnumType.STRING)
  private DosyaTur tur;

  @Override
  public int hashCode() {
    return new HashCodeBuilder().appendSuper(super.hashCode()).append(this.ad).append(this.uzantiAd).append(this.veri).append(this.tur).toHashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    final SikayetDosya other = (SikayetDosya) obj;
    return new EqualsBuilder().appendSuper(super.equals(obj)).append(this.ad, other.ad).append(this.uzantiAd, other.uzantiAd).append(this.veri, other.veri)
        .append(this.tur, other.tur).isEquals();
  }

}
