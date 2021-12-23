package tr.gov.*****.*****essp*****.model.entity.reference;

import java.util.stream.Stream;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@JsonFormat(shape = Shape.OBJECT)
public enum KvkkPaylasim {

  EVET(1, "Evet"),
  HAYIR(0, "Hayır");

  private int id;
  private String label;

  private KvkkPaylasim(int id, String label) {
    this.id = id;
    this.label = label;
  }

  public int getId() {
    return id;
  }

  public String getLabel() {
    return label;
  }

  public static KvkkPaylasim decode(final int id) {
    return Stream.of(values()).filter(targetEnum -> targetEnum.getId() == id).findFirst().orElse(null);
  }

}
