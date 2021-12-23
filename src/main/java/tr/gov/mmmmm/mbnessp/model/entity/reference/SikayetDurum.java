package tr.gov.*****.*****essp*****.model.entity.reference;

import java.util.stream.Stream;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@JsonFormat(shape = Shape.OBJECT)
public enum SikayetDurum {

  YENI_GELEN(1, "Yeni Gelen", "Bekleyen", ""),
  KURULUSA_YONLENDIRILEN(2, "Kuruluşa Yönlendirilen", "Bekleyen", "Yeni Gelen"),
  KURULUSTAN_GELEN(3, "Kuruluştan Gelenler", "Bekleyen", "Cevaplananlar"),
  IADE(4, "İade", "Bekleyen", "İade"),
  BIRIME_YONLENDIRILEN(5, "Banka İçi Yönlendirilen", "Bekleyen", "Cevaplanan"),
  // Müdür onayı bekleyen
  ONAY_BEKLEYEN(6, "Onay Bekleyen", "Bekleyen", "Cevaplanan"),
  CEVAPLANAN(7, "Cevaplanan", "Cevaplanan", "Cevaplanan");

  private int id;
  private String *****Label;
  private String kullaniciLabel;
  private String bankaLabel;

  SikayetDurum(int id, String *****Label, String kullaniciLabel, String bankaLabel) {
    this.id = id;
    this.*****Label = *****Label;
    this.kullaniciLabel = kullaniciLabel;
    this.bankaLabel = bankaLabel;
  }

  public int getId() {
    return id;
  }

  public String get*****Label() {
    return *****Label;
  }

  public String getKullaniciLabel() {
    return kullaniciLabel;
  }

  public String getBankaLabel() {
    return bankaLabel;
  }

  public static SikayetDurum decode(final int id) {
    return Stream.of(values()).filter(item -> item.getId() == id).findFirst().orElse(null);
  }

}
