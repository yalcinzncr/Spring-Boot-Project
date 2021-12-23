package tr.gov.*****.*****esspkullanici.service;

import static org.junit.Assert.assertNotNull;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import tr.gov.*****.*****essp*****.model.dto.SikayetDTO;
import tr.gov.*****.*****essp*****.repository.SikayetRepository;
import tr.gov.*****.*****essp*****.service.domain.SikayetService;

@SpringBootTest
public class SikayetServiceTest {

  private @Mock ModelMapper modelMapper;
  private @Mock SikayetRepository sikayetRepository;
  private @InjectMocks SikayetService sikayetService = new SikayetService();

  @Test
  public void findById() {
    Page<SikayetDTO> sikayetPageDTO = sikayetService.findAll(PageRequest.of(0, 10));
    assertNotNull(sikayetPageDTO);
  }

}
