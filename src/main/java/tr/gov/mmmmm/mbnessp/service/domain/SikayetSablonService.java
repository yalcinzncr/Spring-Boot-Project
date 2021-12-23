package tr.gov.*****.*****essp*****.service.domain;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tr.gov.*****.*****essp*****.exception.ApiException;
import tr.gov.*****.*****essp*****.model.dto.SikayetSablonDTO;
import tr.gov.*****.*****essp*****.model.entity.SikayetAltKonu;
import tr.gov.*****.*****essp*****.model.entity.SikayetKonu;
import tr.gov.*****.*****essp*****.model.entity.SikayetSablon;
import tr.gov.*****.*****essp*****.model.entity.SikayetTur;
import tr.gov.*****.*****essp*****.repository.SikayetAltKonuRepository;
import tr.gov.*****.*****essp*****.repository.SikayetKonuRepository;
import tr.gov.*****.*****essp*****.repository.SikayetSablonRepository;
import tr.gov.*****.*****essp*****.repository.SikayetTurRepository;

@Service
public class SikayetSablonService {

	private @Autowired ModelMapper modelMapper;
	private @Autowired SikayetSablonRepository sikayetSablonRepository;
	private @Autowired SikayetAltKonuRepository sikayetAltKonuRepository;
	private @Autowired SikayetKonuRepository sikayetKonuRepository;
	private @Autowired SikayetTurRepository sikayetTurRepository;
	

	@Transactional(readOnly = true)
	public List<SikayetSablonDTO> findAll() {
		List<SikayetSablon> sikayetSablon = sikayetSablonRepository.findAll();
		return modelMapper.map(sikayetSablon, new TypeToken<List<SikayetSablonDTO>>() {}.getType());

	}

	@Transactional
	public void kaydet(SikayetSablonDTO sikayetSablonDTO) {
		
		SikayetTur persitentsikayetTur = sikayetTurRepository.findById(sikayetSablonDTO.getTur().getId()).orElseThrow(() -> new ApiException("Şikayet Türü bulunamadı!"));
	    SikayetKonu persistentSikayetKonu = sikayetKonuRepository.findById(sikayetSablonDTO.getKonu().getId()).orElseThrow(() -> new ApiException("Şikayet Konusu bulunamadı!"));
	    SikayetAltKonu persistentSikayetAltKonu = sikayetAltKonuRepository.findById(sikayetSablonDTO.getAltKonu().getId()).orElseThrow(() -> new ApiException("Şikayet Alt Konusu bulunamadı!"));
		
		SikayetSablon sikayetSablon = new SikayetSablon();
		sikayetSablon.setAktifPasif(sikayetSablonDTO.getAktifPasif());
		sikayetSablon.setMetin(sikayetSablonDTO.getMetin());
		sikayetSablon.setAltKonu(persistentSikayetAltKonu);
		sikayetSablon.setKonu(persistentSikayetKonu);
		sikayetSablon.setTur(persitentsikayetTur);
		sikayetSablonRepository.save(sikayetSablon);
	}

	@Transactional(readOnly = true)
	public SikayetSablonDTO getir(Long id) {
		return modelMapper.map(sikayetSablonRepository.getOne(id), SikayetSablonDTO.class);
	}
	
	@Transactional
	public void guncelle(SikayetSablonDTO sikayetSablonDTO) {
		
		SikayetTur persitentsikayetTur = sikayetTurRepository.findById(sikayetSablonDTO.getTur().getId()).orElseThrow(() -> new ApiException("Şikayet Türü bulunamadı!"));
	    SikayetKonu persistentSikayetKonu = sikayetKonuRepository.findById(sikayetSablonDTO.getKonu().getId()).orElseThrow(() -> new ApiException("Şikayet Konusu bulunamadı!"));
	    SikayetAltKonu persistentSikayetAltKonu = sikayetAltKonuRepository.findById(sikayetSablonDTO.getAltKonu().getId()).orElseThrow(() -> new ApiException("Şikayet Alt Konusu bulunamadı!"));
		
		SikayetSablon sikayetSablon = new SikayetSablon();
		sikayetSablon.setId(sikayetSablonDTO.getId());
		sikayetSablon.setAktifPasif(sikayetSablonDTO.getAktifPasif());
		sikayetSablon.setMetin(sikayetSablonDTO.getMetin());
		sikayetSablon.setAltKonu(persistentSikayetAltKonu);
		sikayetSablon.setKonu(persistentSikayetKonu);
		sikayetSablon.setTur(persitentsikayetTur);
		sikayetSablonRepository.save(sikayetSablon);
	}

}
