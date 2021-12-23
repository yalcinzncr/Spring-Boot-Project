package tr.gov.*****.*****essp*****.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tr.gov.*****.*****essp*****.model.dto.SikayetDTO;
import tr.gov.*****.*****essp*****.model.dto.VMInterface.SikayetGuncelle;
import tr.gov.*****.*****essp*****.model.entity.metamodel.SikayetMM;
import tr.gov.*****.*****essp*****.model.entity.reference.SikayetDurum;
import tr.gov.*****.*****essp*****.service.domain.SikayetService;

@RestController
@RequestMapping("/sikayet")
public class SikayetController extends BaseController {

  private @Autowired SikayetService sikayetService;

  @GetMapping("/listele")
  public Page<SikayetDTO> listele(@RequestParam("page") int page, @RequestParam("size") int size) {
    return sikayetService.findAll(PageRequest.of(page, size));
  }
  
  @GetMapping("/listele-bydurum")
  public Page<SikayetDTO> listeleBySikayetDurum(@RequestParam("durum") List<SikayetDurum> durumList, @RequestParam("page") int page, @RequestParam("size") int size) {
    return sikayetService.findAllBySikayetDurum(durumList , PageRequest.of(page, size, Sort.by(Direction.DESC, SikayetMM.BASVURU_TARIH)));
  }
  
  @PostMapping("/guncelle")
  public void guncelle(@Validated ({SikayetGuncelle.class}) @RequestBody SikayetDTO sikayetDTO) {
		SikayetDTO sikayetDTONew = sikayetService.sikayetGetir(sikayetDTO.getId());
		sikayetDTONew.setDurum(sikayetDTO.getDurum());
		sikayetService.guncelleSikayetDurum(sikayetDTONew);
	
	}

}
