package tr.gov.*****.*****essp*****.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import tr.gov.*****.*****essp*****.model.entity.reference.SikayetDurum;

@Getter
@Setter
@Entity
@Table(name = "TSIKAYET_LOG", schema = "*****ESSP")
public class SikayetLog extends BaseEntity {

  private static final long serialVersionUID = 1L;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "SIKAYET_ID")
  private Sikayet sikayet;

  @Column(name = "SIKAYET_DURUM")
  @Enumerated(EnumType.STRING)
  private SikayetDurum durum;

}
