package tr.gov.*****.*****essp*****.model.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import lombok.Getter;
import lombok.Setter;
import tr.gov.*****.*****essp*****.model.entity.reference.AktifPasif;

@Getter
@Setter
@Entity
@Table(name = "TDUYURU", schema = "*****ESSP")
public class Duyuru extends BaseEntity {

  private static final long serialVersionUID = 1L;

  @Column(name = "BASLIK")
  private String baslik;

  @Column(name = "ICERIK", length = 2000)
  private String icerik;

  @Column(name = "AKTIF_FLAG")
  @Enumerated(EnumType.STRING)
  private AktifPasif aktifPasif;

  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "duyuru", orphanRemoval = true)
  private List<DuyuruDosya> dosyalar = new ArrayList<>();

  @Override
  public int hashCode() {
    return new HashCodeBuilder().appendSuper(super.hashCode()).append(this.baslik).append(this.icerik).toHashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    final Duyuru other = (Duyuru) obj;
    return new EqualsBuilder().appendSuper(super.equals(obj)).append(this.baslik, other.baslik).append(this.icerik, other.icerik).isEquals();
  }

}
