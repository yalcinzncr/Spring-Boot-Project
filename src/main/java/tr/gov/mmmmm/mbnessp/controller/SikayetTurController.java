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

import tr.gov.*****.*****essp*****.model.dto.SikayetTurDTO;
import tr.gov.*****.*****essp*****.service.domain.SikayetTurService;
import tr.gov.*****.*****essp*****.model.dto.VMInterface.SikayetTurGuncelle;

@RestController
@RequestMapping("/sikayetTur")
public class SikayetTurController extends BaseController {

  private @Autowired SikayetTurService sikayetTurService;

	@GetMapping("/listele")
	public List<SikayetTurDTO> listele() {
		return sikayetTurService.findAll();
	}

	@PostMapping("/ekle")
	public void ekle(@Validated ({SikayetTurGuncelle.class}) @RequestBody SikayetTurDTO sikayetTurDTO) {
		sikayetTurService.kaydet(sikayetTurDTO);
	}
		
	@GetMapping("/getir")
	public SikayetTurDTO getir(@RequestParam(name = "id") Long id) {
		return sikayetTurService.sikayetTurGetir(id);
	}
	
	@PostMapping("/guncelle")
	public void guncelle(@Validated ({SikayetTurGuncelle.class}) @RequestBody SikayetTurDTO sikayetTurDTO) {
		SikayetTurDTO sikayetTurDTONew = sikayetTurService.sikayetTurGetir(sikayetTurDTO.getId());
		sikayetTurDTONew.setAd(sikayetTurDTO.getAd());
		sikayetTurDTONew.setAktifPasif(sikayetTurDTO.getAktifPasif());
		sikayetTurDTONew.setMudurluk(sikayetTurDTO.getMudurluk());
		sikayetTurService.guncelle(sikayetTurDTONew);
	
	}

}
