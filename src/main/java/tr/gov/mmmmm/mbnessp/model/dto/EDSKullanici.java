package tr.gov.*****.*****essp*****.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EDSKullanici implements Serializable {

  private static final long serialVersionUID = 1L;
  
  private Integer siraNo;
  private String sicil;
  private String kullaniciKodu;
  private String adSoyad;
  private String mudurluk;
  private String unvan;
  private List<String> roller = new ArrayList<>();

}
