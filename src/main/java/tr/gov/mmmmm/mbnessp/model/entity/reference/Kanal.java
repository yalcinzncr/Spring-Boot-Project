package tr.gov.*****.*****essp*****.model.entity.reference;

import java.util.stream.Stream;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@JsonFormat(shape = Shape.OBJECT)
public enum Kanal {

  SIKAYET_YONETIM_SISTEMI(1, "Şikayet Yönetim Sistemi"),
  BDDK(2, "BDDK"),
  CIMER(3, "CİMER"),
  DIGER(4, "Diğer");

  private int id;
  private String label;

  private Kanal(int id, String label) {
    this.id = id;
    this.label = label;
  }

  public int getId() {
    return id;
  }

  public String getLabel() {
    return label;
  }

  public Kanal decode(final int id) {
    return Stream.of(values()).filter(targetEnum -> targetEnum.getId() == id).findFirst().orElse(null);
  }

}
