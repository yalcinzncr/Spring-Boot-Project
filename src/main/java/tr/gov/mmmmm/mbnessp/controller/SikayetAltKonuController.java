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

import tr.gov.*****.*****essp*****.model.dto.SikayetAltKonuDTO;
import tr.gov.*****.*****essp*****.service.domain.SikayetAltKonuService;
import tr.gov.*****.*****essp*****.model.dto.VMInterface.SikayetAltKonuGuncelle;

@RestController
@RequestMapping("/sikayetAltKonu")
public class SikayetAltKonuController extends BaseController {

	private @Autowired SikayetAltKonuService sikayetAltKonuService;

	@GetMapping("/listele")
	public List<SikayetAltKonuDTO> listele() {
		return sikayetAltKonuService.findAll();
	}

	@PostMapping("/ekle")
	public void ekle(@Validated ({SikayetAltKonuGuncelle.class})  @RequestBody SikayetAltKonuDTO sikayetAltKonuDTO) {
		sikayetAltKonuService.kaydet(sikayetAltKonuDTO);
	}

	@GetMapping("/getir")
	public SikayetAltKonuDTO getir(@RequestParam(name = "id") Long id) {
		return sikayetAltKonuService.getir(id);
	}

	@PostMapping("/guncelle")
	public void guncelle(@Validated ({SikayetAltKonuGuncelle.class}) @RequestBody SikayetAltKonuDTO sikayetAltKonuDTO) {
		SikayetAltKonuDTO sikayetAltKonuDTONew = sikayetAltKonuService.getir(sikayetAltKonuDTO.getId());
		sikayetAltKonuDTONew.setAd(sikayetAltKonuDTO.getAd());
		sikayetAltKonuDTONew.setAktifPasif(sikayetAltKonuDTO.getAktifPasif());
		sikayetAltKonuDTONew.setKonu(sikayetAltKonuDTO.getKonu());
		sikayetAltKonuService.guncelle(sikayetAltKonuDTONew);
	}

}
