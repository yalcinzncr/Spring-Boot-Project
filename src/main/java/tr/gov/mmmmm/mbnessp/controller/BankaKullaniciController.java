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

import tr.gov.*****.*****essp*****.model.dto.BankaKullaniciDTO;
import tr.gov.*****.*****essp*****.model.dto.VMInterface.BankaKullaniciGuncelle;
import tr.gov.*****.*****essp*****.service.domain.BankaKullaniciService;

@RestController
@RequestMapping("/bankaKullanici")
public class BankaKullaniciController extends BaseController {

  private @Autowired BankaKullaniciService bankaKullaniciService;

	@GetMapping("/listele")
	public List<BankaKullaniciDTO> listele() {
		return bankaKullaniciService.findAll();
	}

	@PostMapping("/ekle")
	public void ekle(@Validated({ BankaKullaniciGuncelle.class }) @RequestBody BankaKullaniciDTO bankaKullaniciDTO) {
		bankaKullaniciService.kaydet(bankaKullaniciDTO);
	}
		
	@GetMapping("/getir")
	public BankaKullaniciDTO getir(@RequestParam(name = "id") Long id) {
		return bankaKullaniciService.getir(id);
	}
	
	@PostMapping("/guncelle")
	public void guncelle(@Validated({ BankaKullaniciGuncelle.class }) @RequestBody BankaKullaniciDTO bankaKullaniciDTO) {
		BankaKullaniciDTO bankaKullaniciDTONew = bankaKullaniciService.getir(bankaKullaniciDTO.getId());
		bankaKullaniciDTONew.setAdSoyad(bankaKullaniciDTO.getAdSoyad());
		bankaKullaniciDTONew.setAktifPasif(bankaKullaniciDTO.getAktifPasif());
		bankaKullaniciDTONew.setBirim(bankaKullaniciDTO.getBirim());
		bankaKullaniciDTONew.setCepTel(bankaKullaniciDTO.getCepTel());
		bankaKullaniciDTONew.setEposta(bankaKullaniciDTO.getEposta());
		bankaKullaniciDTONew.setRol(bankaKullaniciDTO.getRol());
		bankaKullaniciDTONew.setSifre(bankaKullaniciDTO.getSifre());
		bankaKullaniciDTONew.setTelefon(bankaKullaniciDTO.getTelefon());
		bankaKullaniciDTONew.setUnvan(bankaKullaniciDTO.getUnvan());
		bankaKullaniciDTONew.setKurulus(bankaKullaniciDTO.getKurulus());
		bankaKullaniciService.guncelle(bankaKullaniciDTONew);
	
	}

}
