package tr.gov.*****.*****essp*****.model.entity.reference;

import java.util.stream.Stream;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import tr.gov.*****.*****essp*****.deserializer.BankaKullaniciRolDeserializer;

@JsonFormat(shape = Shape.OBJECT)
@JsonDeserialize(using = BankaKullaniciRolDeserializer.class)
public enum BankaKullaniciRol {

  ADMIN(1, "Yönetici"),
  DEFAULT(2, "Standart");

  private int id;
  private String label;

  private BankaKullaniciRol(int id, String label) {
    this.id = id;
    this.label = label;
  }

  public int getId() {
    return id;
  }

  public String getLabel() {
    return label;
  }

  public static BankaKullaniciRol decode(final int id) {
    return Stream.of(BankaKullaniciRol.values()).filter(targetEnum -> targetEnum.getId() == id).findFirst().orElse(null);
  }

}
