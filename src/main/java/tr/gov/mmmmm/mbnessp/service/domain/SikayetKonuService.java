package tr.gov.*****.*****essp*****.service.domain;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tr.gov.*****.*****essp*****.exception.ApiException;
import tr.gov.*****.*****essp*****.model.dto.SikayetKonuDTO;
import tr.gov.*****.*****essp*****.model.entity.SikayetKonu;
import tr.gov.*****.*****essp*****.model.entity.SikayetTur;
import tr.gov.*****.*****essp*****.repository.SikayetKonuRepository;
import tr.gov.*****.*****essp*****.repository.SikayetTurRepository;

@Service
public class SikayetKonuService {

	private @Autowired ModelMapper modelMapper;
	private @Autowired SikayetKonuRepository sikayetKonuRepository;
	private @Autowired SikayetTurRepository sikayetTurRepository;

	@Transactional(readOnly = true)
	public List<SikayetKonuDTO> findAll() {
		List<SikayetKonu> sikayetKonu = sikayetKonuRepository.findAll();
		return modelMapper.map(sikayetKonu, new TypeToken<List<SikayetKonuDTO>>() {}.getType());

	}

	@Transactional
	public void kaydet(SikayetKonuDTO sikayetKonuDTO) {
		SikayetTur persitentsikayetTur = sikayetTurRepository.findById(sikayetKonuDTO.getTur().getId()).orElseThrow(() -> new ApiException("Şikayet Türü bulunamadı!"));
		SikayetKonu sikayetKonu = new SikayetKonu();
		sikayetKonu.setAd(sikayetKonuDTO.getAd());
		sikayetKonu.setAktifPasif(sikayetKonuDTO.getAktifPasif());
		sikayetKonu.setTur(persitentsikayetTur);		
		sikayetKonuRepository.save(sikayetKonu);
	}

	@Transactional(readOnly = true)
	public SikayetKonuDTO getir(Long id) {
		return modelMapper.map(sikayetKonuRepository.getOne(id), SikayetKonuDTO.class);
	}
	
	@Transactional
	public void guncelle(SikayetKonuDTO sikayetKonuDTO) {
		SikayetTur persitentsikayetTur = sikayetTurRepository.findById(sikayetKonuDTO.getTur().getId()).orElseThrow(() -> new ApiException("Şikayet Türü bulunamadı!"));
		SikayetKonu sikayetKonu = new SikayetKonu();
		sikayetKonu.setId(sikayetKonuDTO.getId());
		sikayetKonu.setAd(sikayetKonuDTO.getAd());
		sikayetKonu.setAktifPasif(sikayetKonuDTO.getAktifPasif());
		sikayetKonu.setTur(persitentsikayetTur);
		sikayetKonuRepository.save(sikayetKonu);
	}

}
