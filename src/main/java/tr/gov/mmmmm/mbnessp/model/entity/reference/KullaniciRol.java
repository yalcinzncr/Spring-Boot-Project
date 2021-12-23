package tr.gov.*****.*****essp*****.model.entity.reference;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@JsonFormat(shape = Shape.OBJECT)
public enum KullaniciRol {

  GMY("GMY"),
  MUDUR("Müdür"),
  CALISAN("Çalışan");

  private String label;

  private KullaniciRol(String label) {
    this.label = label;
  }

  public String getLabel() {
    return label;
  }

}
