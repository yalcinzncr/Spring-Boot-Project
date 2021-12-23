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

import tr.gov.*****.*****essp*****.model.dto.KurulusTurDTO;
import tr.gov.*****.*****essp*****.service.domain.KurulusTurService;
import tr.gov.*****.*****essp*****.model.dto.VMInterface.KurulusTurGuncelle;

@RestController
@RequestMapping("/kurulusTur")
public class KurulusTurController extends BaseController {

  private @Autowired KurulusTurService kurulusTurService;

	@GetMapping("/listele")
	public List<KurulusTurDTO> listele() {
		return kurulusTurService.findAll();
	}

	@PostMapping("/ekle")
	public void ekle(@Validated ({KurulusTurGuncelle.class}) @RequestBody KurulusTurDTO kurulusTurDTO) {
		kurulusTurService.kaydet(kurulusTurDTO);
	}
		
	@GetMapping("/getir")
	public KurulusTurDTO getir(@RequestParam(name = "id") Long id) {
		return kurulusTurService.getir(id);
	}
	
	@PostMapping("/guncelle")
	public void guncelle(@Validated ({KurulusTurGuncelle.class}) @RequestBody KurulusTurDTO kurulusTurDTO) {
		KurulusTurDTO kurulusTurDTONew = kurulusTurService.getir(kurulusTurDTO.getId());
		kurulusTurDTONew.setAd(kurulusTurDTO.getAd());
		kurulusTurDTONew.setAktifPasif(kurulusTurDTO.getAktifPasif());
		kurulusTurService.guncelle(kurulusTurDTONew);
	
	}

}
