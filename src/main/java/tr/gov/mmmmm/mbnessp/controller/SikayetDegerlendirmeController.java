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

import tr.gov.*****.*****essp*****.model.dto.SikayetDegerlendirmeDTO;
import tr.gov.*****.*****essp*****.model.dto.VMInterface.SikayetDegerlendirmeGuncelle;
import tr.gov.*****.*****essp*****.service.domain.SikayetDegerlendirmeService;

@RestController
@RequestMapping("/sikayetDegerlendirme")
public class SikayetDegerlendirmeController extends BaseController {

	private @Autowired SikayetDegerlendirmeService sikayetDegerlendirmeService;

	@GetMapping("/listele")
	public List<SikayetDegerlendirmeDTO> listele() {
		return sikayetDegerlendirmeService.findAll();
	}

	@PostMapping("/ekle")
	public void ekle(@Validated({ SikayetDegerlendirmeGuncelle.class }) @RequestBody SikayetDegerlendirmeDTO sikayetDegerlendirmeDTO) {
		sikayetDegerlendirmeService.kaydet(sikayetDegerlendirmeDTO);
	}

	@GetMapping("/getir")
	public SikayetDegerlendirmeDTO getir(@RequestParam(name = "id") Long id) {
		return sikayetDegerlendirmeService.sikayetDegerlendirmeGetir(id);
	}

	@PostMapping("/guncelle")
	public void guncelle(@Validated({ SikayetDegerlendirmeGuncelle.class }) @RequestBody SikayetDegerlendirmeDTO sikayetDegerlendirmeDTO) {
		SikayetDegerlendirmeDTO sikayetDegerlendirmeDTONew = sikayetDegerlendirmeService.sikayetDegerlendirmeGetir(sikayetDegerlendirmeDTO.getId());
		sikayetDegerlendirmeDTONew.setAd(sikayetDegerlendirmeDTO.getAd());
		sikayetDegerlendirmeDTONew.setAktifPasif(sikayetDegerlendirmeDTO.getAktifPasif());
		sikayetDegerlendirmeService.guncelle(sikayetDegerlendirmeDTONew);

	}

}
