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
import tr.gov.*****.*****essp*****.model.entity.reference.AktifPasif;

@Getter
@Setter
@Entity
@Table(name = "TSIKAYET_SABLON", schema = "*****ESSP")
public class SikayetSablon extends BaseEntity {

  private static final long serialVersionUID = 1L;

  @Lob
  @Column(name = "METIN", nullable = false)
  private String metin;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "SIKAYET_TUR_ID")
  private SikayetTur tur;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "SIKAYET_KONU_ID")
  private SikayetKonu konu;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "SIKAYET_ALT_KONU_ID")
  private SikayetAltKonu altKonu;

  @Column(name = "AKTIF_FLAG")
  @Enumerated(EnumType.STRING)
  private AktifPasif aktifPasif;

  @Override
  public int hashCode() {
    return new HashCodeBuilder().appendSuper(super.hashCode()).append(this.metin).append(this.tur).append(this.konu).append(this.altKonu)
        .append(this.aktifPasif).toHashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    final SikayetSablon other = (SikayetSablon) obj;
    return new EqualsBuilder().appendSuper(super.equals(obj)).append(this.metin, other.metin).append(this.tur, other.tur).append(this.konu, other.konu).append(this.altKonu, other.altKonu)
        .append(this.aktifPasif, other.aktifPasif).isEquals();
  }

}
