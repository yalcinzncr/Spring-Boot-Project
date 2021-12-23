package tr.gov.*****.*****essp*****.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tr.gov.*****.*****essp*****.model.dto.SikayetSablonDTO;
import tr.gov.*****.*****essp*****.model.dto.VMInterface.SikayetSablonGuncelle;
import tr.gov.*****.*****essp*****.service.domain.SikayetSablonService;

@RestController
@RequestMapping("/sikayetSablon")
public class SikayetSablonController extends BaseController {

  private @Autowired SikayetSablonService sikayetSablonService;

	@GetMapping("/listele")
	public List<SikayetSablonDTO> listele() {
		return sikayetSablonService.findAll();
	}

	@PostMapping("/ekle")
	public void ekle(@Validated ({SikayetSablonGuncelle.class}) @RequestBody SikayetSablonDTO sikayetSablonDTO) {
		sikayetSablonService.kaydet(sikayetSablonDTO);
	}
		
	@GetMapping("/getir")
	public SikayetSablonDTO getir(@RequestParam(name = "id") Long id) {
		return sikayetSablonService.getir(id);
	}
	
	@PostMapping("/guncelle")
	public void guncelle(@Validated ({SikayetSablonGuncelle.class}) @RequestBody SikayetSablonDTO sikayetSablonDTO) {
		SikayetSablonDTO sikayetSablonDTONew = sikayetSablonService.getir(sikayetSablonDTO.getId());
		sikayetSablonDTONew.setAktifPasif(sikayetSablonDTO.getAktifPasif());
		sikayetSablonDTONew.setMetin(sikayetSablonDTO.getMetin());
		sikayetSablonDTONew.setAltKonu(sikayetSablonDTO.getAltKonu());
		sikayetSablonDTONew.setKonu(sikayetSablonDTO.getKonu());
		sikayetSablonDTONew.setTur(sikayetSablonDTO.getTur());
		sikayetSablonService.guncelle(sikayetSablonDTONew);
	
	}

}
