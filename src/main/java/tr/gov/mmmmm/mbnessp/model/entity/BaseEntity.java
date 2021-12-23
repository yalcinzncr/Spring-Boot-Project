package tr.gov.*****.*****essp*****.model.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "YRTM_KULLANICI_ID", updatable = false)
  private Integer yrtmKullaniciId;

  @Column(name = "GUNC_KULLANICI_ID")
  private Integer guncKullaniciId;

  @Column(name = "YRTM_ZAMAN")
  @Temporal(TemporalType.TIMESTAMP)
  private Date yrtmZaman;

  @Column(name = "GUNC_ZAMAN")
  @Temporal(TemporalType.TIMESTAMP)
  private Date guncZaman;

  @Override
  public int hashCode() {
    return new HashCodeBuilder().append(this.id).append(this.yrtmKullaniciId).append(yrtmZaman).append(guncKullaniciId).append(guncZaman).toHashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    final BaseEntity other = (BaseEntity) obj;
    return new EqualsBuilder().append(this.id, other.id).append(this.yrtmKullaniciId, other.yrtmKullaniciId).append(this.yrtmZaman, other.yrtmZaman)
        .append(this.guncKullaniciId, other.guncKullaniciId).append(this.guncZaman, other.guncZaman).isEquals();
  }

}
