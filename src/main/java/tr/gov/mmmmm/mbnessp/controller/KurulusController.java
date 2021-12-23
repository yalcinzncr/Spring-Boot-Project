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

import tr.gov.*****.*****essp*****.model.dto.KurulusDTO;
import tr.gov.*****.*****essp*****.service.domain.KurulusService;
import tr.gov.*****.*****essp*****.model.dto.VMInterface.KurulusGuncelle;

@RestController
@RequestMapping("/kurulus")
public class KurulusController extends BaseController {

  private @Autowired KurulusService kurulusService;

	@GetMapping("/listele")
	public List<KurulusDTO> listele() {
		return kurulusService.findAll();
	}

	@PostMapping("/ekle")
	public void ekle(@Validated ({KurulusGuncelle.class}) @RequestBody KurulusDTO kurulusDTO) {
		kurulusService.kaydet(kurulusDTO);
	}
		
	@GetMapping("/getir")
	public KurulusDTO getir(@RequestParam(name = "id") Long id) {
		return kurulusService.getir(id);
	}
	
	@PostMapping("/guncelle")
	public void guncelle(@Validated ({KurulusGuncelle.class}) @RequestBody KurulusDTO kurulusDTO) {
		KurulusDTO kurulusDTONew = kurulusService.getir(kurulusDTO.getId());
		kurulusDTONew.setAd(kurulusDTO.getAd());
		kurulusDTONew.setAktifPasif(kurulusDTO.getAktifPasif());
		kurulusDTONew.setTur(kurulusDTO.getTur());
		kurulusService.guncelle(kurulusDTONew);
	
	}

}
