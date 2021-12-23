package tr.gov.*****.*****essp*****.service.domain;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tr.gov.*****.*****essp*****.exception.ApiException;
import tr.gov.*****.*****essp*****.model.dto.SikayetAltKonuDTO;
import tr.gov.*****.*****essp*****.model.entity.SikayetAltKonu;
import tr.gov.*****.*****essp*****.model.entity.SikayetKonu;
import tr.gov.*****.*****essp*****.repository.SikayetAltKonuRepository;
import tr.gov.*****.*****essp*****.repository.SikayetKonuRepository;

@Service
public class SikayetAltKonuService {

	private @Autowired ModelMapper modelMapper;
	private @Autowired SikayetKonuRepository sikayetKonuRepository;
	private @Autowired SikayetAltKonuRepository sikayetAltKonuRepository;

	@Transactional(readOnly = true)
	public List<SikayetAltKonuDTO> findAll() {
		List<SikayetAltKonu> sikayetAltKonu = sikayetAltKonuRepository.findAll();
		return modelMapper.map(sikayetAltKonu, new TypeToken<List<SikayetAltKonuDTO>>() {}.getType());

	}

	@Transactional
	public void kaydet(SikayetAltKonuDTO sikayetAltKonuDTO) {
		SikayetKonu persistentSikayetKonu = sikayetKonuRepository.findById(sikayetAltKonuDTO.getKonu().getId()).orElseThrow(() -> new ApiException("Şikayet Konusu bulunamadı!"));
		SikayetAltKonu sikayetAltKonu = new SikayetAltKonu();
		sikayetAltKonu.setAd(sikayetAltKonuDTO.getAd());
		sikayetAltKonu.setAktifPasif(sikayetAltKonuDTO.getAktifPasif());
		sikayetAltKonu.setKonu(persistentSikayetKonu);		
		sikayetAltKonuRepository.save(sikayetAltKonu);
	}

	@Transactional(readOnly = true)
	public SikayetAltKonuDTO getir(Long id) {
		return modelMapper.map(sikayetAltKonuRepository.getOne(id), SikayetAltKonuDTO.class);
	}
	
	@Transactional
	public void guncelle(SikayetAltKonuDTO sikayetAltKonuDTO) {
		SikayetKonu persistentSikayetKonu = sikayetKonuRepository.findById(sikayetAltKonuDTO.getKonu().getId()).orElseThrow(() -> new ApiException("Şikayet Konusu bulunamadı!"));
		SikayetAltKonu sikayetAltKonu = new SikayetAltKonu();
		sikayetAltKonu.setId(sikayetAltKonuDTO.getId());
		sikayetAltKonu.setAd(sikayetAltKonuDTO.getAd());
		sikayetAltKonu.setAktifPasif(sikayetAltKonuDTO.getAktifPasif());
		sikayetAltKonu.setKonu(persistentSikayetKonu);	
		sikayetAltKonuRepository.save(sikayetAltKonu);
	}

}
