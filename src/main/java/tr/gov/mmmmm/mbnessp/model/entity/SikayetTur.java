package tr.gov.*****.*****essp*****.model.entity;

import java.util.ArrayList;
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
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import lombok.Getter;
import lombok.Setter;
import tr.gov.*****.*****essp*****.model.entity.reference.AktifPasif;

@Getter
@Setter
@Entity
@Table(name = "TSIKAYET_TUR", schema = "*****ESSP")
public class SikayetTur extends BaseEntity {

  private static final long serialVersionUID = 1L;

  @Column(name = "AD", nullable = false)
  private String ad;

  @Column(name = "AKTIF_FLAG")
  @Enumerated(EnumType.STRING)
  private AktifPasif aktifPasif;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "MUDURLUK_ID")
  private Mudurluk mudurluk;

  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "tur", orphanRemoval = true)
  private List<SikayetKonu> konular = new ArrayList<>();

  @Override
  public int hashCode() {
    return new HashCodeBuilder().appendSuper(super.hashCode()).append(this.ad).append(this.aktifPasif).append(this.mudurluk).toHashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    final SikayetTur other = (SikayetTur) obj;
    return new EqualsBuilder().appendSuper(super.equals(obj)).append(this.ad, other.ad).append(this.aktifPasif, other.aktifPasif)
        .append(this.mudurluk, other.mudurluk).isEquals();
  }

}
