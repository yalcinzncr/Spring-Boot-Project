package tr.gov.*****.*****essp*****.exception;

public class ApiException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public ApiException(String mesaj) {
    super(mesaj);
  }

}
