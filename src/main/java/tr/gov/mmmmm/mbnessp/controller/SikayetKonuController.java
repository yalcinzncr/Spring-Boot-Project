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

import tr.gov.*****.*****essp*****.model.dto.SikayetKonuDTO;
import tr.gov.*****.*****essp*****.service.domain.SikayetKonuService;
import tr.gov.*****.*****essp*****.model.dto.VMInterface.SikayetKonuGuncelle;

@RestController
@RequestMapping("/sikayetKonu")
public class SikayetKonuController extends BaseController {

  private @Autowired SikayetKonuService sikayetKonuService;

	@GetMapping("/listele")
	public List<SikayetKonuDTO> listele() {
		return sikayetKonuService.findAll();
	}

	@PostMapping("/ekle")
	public void ekle(@Validated ({SikayetKonuGuncelle.class}) @RequestBody SikayetKonuDTO sikayetKonuDTO) {
		sikayetKonuService.kaydet(sikayetKonuDTO);
	}
		
	@GetMapping("/getir")
	public SikayetKonuDTO getir(@RequestParam(name = "id") Long id) {
		return sikayetKonuService.getir(id);
	}
	
	@PostMapping("/guncelle")
	public void guncelle(@Validated ({SikayetKonuGuncelle.class}) @RequestBody SikayetKonuDTO sikayetKonuDTO) {
		SikayetKonuDTO sikayetKonuDTONew = sikayetKonuService.getir(sikayetKonuDTO.getId());
		sikayetKonuDTONew.setAd(sikayetKonuDTO.getAd());
		sikayetKonuDTONew.setAktifPasif(sikayetKonuDTO.getAktifPasif());
		sikayetKonuDTONew.setTur(sikayetKonuDTO.getTur());
		sikayetKonuService.guncelle(sikayetKonuDTONew);
	
	}

}
