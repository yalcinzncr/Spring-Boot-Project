package tr.gov.*****.*****essp*****.controller;

import java.util.List;

import static tr.gov.*****.*****essp*****.model.dto.VMInterface.MudurlukGuncelle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tr.gov.*****.*****essp*****.model.dto.MudurlukDTO;
import tr.gov.*****.*****essp*****.service.domain.MudurlukService;

@RestController
@RequestMapping("/mudurluk")
public class MudurlukController extends BaseController {

	private @Autowired MudurlukService mudurlukService;

	@GetMapping("/listele")
	public List<MudurlukDTO> listele() {
		return mudurlukService.findAll();
	}

	@PostMapping("/ekle")
	public void ekle(@Validated({ MudurlukGuncelle.class }) @RequestBody MudurlukDTO mudurlukDTO) {
		mudurlukService.kaydet(mudurlukDTO);
	}

	@GetMapping("/getir")
	public MudurlukDTO getir(@RequestParam(name = "id") Long id) {
		return mudurlukService.mudurlukGetir(id);
	}

	@PostMapping("/guncelle")
	public void guncelle(@Validated({ MudurlukGuncelle.class }) @RequestBody MudurlukDTO mudurlukDTO) {
		MudurlukDTO mudurlukDTONew = mudurlukService.mudurlukGetir(mudurlukDTO.getId());
		mudurlukDTONew.setAd(mudurlukDTO.getAd());
		mudurlukDTONew.setAktifPasif(mudurlukDTO.getAktifPasif());
		mudurlukService.guncelle(mudurlukDTONew);

	}

}
