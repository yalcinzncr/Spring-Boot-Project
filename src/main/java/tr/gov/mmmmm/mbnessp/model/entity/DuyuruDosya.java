package tr.gov.*****.*****essp*****.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TDUYURU_DOSYA", schema = "*****ESSP")
public class DuyuruDosya extends BaseEntity {

  private static final long serialVersionUID = 1L;

  @Column(name = "AD", length = 200, nullable = false)
  private String ad;

  @Column(name = "UZANTI_AD", length = 200, nullable = false)
  private String uzantiAd;

  @Lob
  @Column(name = "VERI", length = 5242880)
  private byte[] veri;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "DUYURU_ID")
  private Duyuru duyuru;

  @Override
  public int hashCode() {
    return new HashCodeBuilder().appendSuper(super.hashCode()).append(this.ad).append(this.uzantiAd).append(this.duyuru).toHashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    final DuyuruDosya other = (DuyuruDosya) obj;
    return new EqualsBuilder().appendSuper(super.equals(obj)).append(this.ad, other.ad).append(this.uzantiAd, other.uzantiAd).append(this.duyuru, other.duyuru)
        .isEquals();
  }

}
