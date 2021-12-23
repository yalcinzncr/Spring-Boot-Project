package tr.gov.*****.*****essp*****.service.domain;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tr.gov.*****.*****essp*****.exception.ApiException;
import tr.gov.*****.*****essp*****.model.dto.BankaKullaniciDTO;
import tr.gov.*****.*****essp*****.model.entity.BankaKullanici;
import tr.gov.*****.*****essp*****.model.entity.Kurulus;
import tr.gov.*****.*****essp*****.repository.BankaKullaniciRepository;
import tr.gov.*****.*****essp*****.repository.KurulusRepository;

@Service
public class BankaKullaniciService {

	private @Autowired ModelMapper modelMapper;
	private @Autowired BankaKullaniciRepository bankaKullaniciRepository;
	private @Autowired KurulusRepository kurulusRepository;

	@Transactional(readOnly = true)
	public List<BankaKullaniciDTO> findAll() {
		List<BankaKullanici> bankaKullanici = bankaKullaniciRepository.findAll();
		return modelMapper.map(bankaKullanici, new TypeToken<List<BankaKullaniciDTO>>() {}.getType());

	}

	@Transactional
	public void kaydet(BankaKullaniciDTO bankaKullaniciDTO) {
		
		Kurulus persistentKurulus = kurulusRepository.findById(bankaKullaniciDTO.getKurulus().getId()).orElseThrow(() -> new ApiException("Kuruluş bulunamadı!"));
		
		BankaKullanici bankaKullanici = new BankaKullanici();
		bankaKullanici.setAdSoyad(bankaKullaniciDTO.getAdSoyad());
		bankaKullanici.setAktifPasif(bankaKullaniciDTO.getAktifPasif());
		bankaKullanici.setBirim(bankaKullaniciDTO.getBirim());
		bankaKullanici.setCepTel(bankaKullaniciDTO.getCepTel());
		bankaKullanici.setEposta(bankaKullaniciDTO.getEposta());
		bankaKullanici.setRol(bankaKullaniciDTO.getRol());
		bankaKullanici.setSifre(bankaKullaniciDTO.getSifre());
		bankaKullanici.setTelefon(bankaKullaniciDTO.getTelefon());
		bankaKullanici.setUnvan(bankaKullaniciDTO.getUnvan());
		bankaKullanici.setKurulus(persistentKurulus);
		bankaKullaniciRepository.save(bankaKullanici);
	}

	@Transactional(readOnly = true)
	public BankaKullaniciDTO getir(Long id) {
		return modelMapper.map(bankaKullaniciRepository.getOne(id), BankaKullaniciDTO.class);
	}
	
	@Transactional
	public void guncelle(BankaKullaniciDTO bankaKullaniciDTO) {
		
		Kurulus persistentKurulus = kurulusRepository.findById(bankaKullaniciDTO.getKurulus().getId()).orElseThrow(() -> new ApiException("Kuruluş bulunamadı!"));
		
		BankaKullanici bankaKullanici = new BankaKullanici();
		bankaKullanici.setId(bankaKullaniciDTO.getId());
		bankaKullanici.setAdSoyad(bankaKullaniciDTO.getAdSoyad());
		bankaKullanici.setAktifPasif(bankaKullaniciDTO.getAktifPasif());
		bankaKullanici.setBirim(bankaKullaniciDTO.getBirim());
		bankaKullanici.setCepTel(bankaKullaniciDTO.getCepTel());
		bankaKullanici.setEposta(bankaKullaniciDTO.getEposta());
		bankaKullanici.setRol(bankaKullaniciDTO.getRol());
		bankaKullanici.setSifre(bankaKullaniciDTO.getSifre());
		bankaKullanici.setTelefon(bankaKullaniciDTO.getTelefon());
		bankaKullanici.setUnvan(bankaKullaniciDTO.getUnvan());
		bankaKullanici.setKurulus(persistentKurulus);
		bankaKullaniciRepository.save(bankaKullanici);
	}
	
}
