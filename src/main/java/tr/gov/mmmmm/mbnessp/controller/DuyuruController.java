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

import tr.gov.*****.*****essp*****.model.dto.DuyuruDTO;
import tr.gov.*****.*****essp*****.model.dto.VMInterface.DuyuruGuncelle;
import tr.gov.*****.*****essp*****.service.domain.DuyuruService;

@RestController
@RequestMapping("/duyuru")
public class DuyuruController extends BaseController {

  private @Autowired DuyuruService duyuruService;

	@GetMapping("/listele")
	public List<DuyuruDTO> listele() {
		return duyuruService.findAll();
	}

	@PostMapping("/ekle")
	public void ekle(@Validated({ DuyuruGuncelle.class }) @RequestBody DuyuruDTO duyuruDTO) {
		duyuruService.kaydet(duyuruDTO);
	}
		
	@GetMapping("/getir")
	public DuyuruDTO getir(@RequestParam(name = "id") Long id) {
		return duyuruService.getir(id);
	}
	
	@PostMapping("/guncelle")
	public void guncelle(@Validated({ DuyuruGuncelle.class }) @RequestBody DuyuruDTO duyuruDTO) {
		DuyuruDTO duyuruDTONew = duyuruService.getir(duyuruDTO.getId());
		duyuruDTONew.setBaslik(duyuruDTO.getBaslik());
		duyuruDTONew.setIcerik(duyuruDTO.getIcerik());
		duyuruDTONew.setAktifPasif(duyuruDTONew.getAktifPasif());
		duyuruService.guncelle(duyuruDTONew);
	
	}

}
