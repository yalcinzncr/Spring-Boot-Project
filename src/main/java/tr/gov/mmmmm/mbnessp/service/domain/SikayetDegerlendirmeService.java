package tr.gov.*****.*****essp*****.service.domain;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tr.gov.*****.*****essp*****.model.dto.SikayetDegerlendirmeDTO;
import tr.gov.*****.*****essp*****.model.entity.SikayetDegerlendirme;
import tr.gov.*****.*****essp*****.repository.SikayetDegerlendirmeRepository;

@Service
public class SikayetDegerlendirmeService {

	private @Autowired ModelMapper modelMapper;
	private @Autowired SikayetDegerlendirmeRepository sikayetDegerlendirmeRepository;

	@Transactional(readOnly = true)
	public List<SikayetDegerlendirmeDTO> findAll() {
		List<SikayetDegerlendirme> sikayetDegerlendirme = sikayetDegerlendirmeRepository.findAll();
		return modelMapper.map(sikayetDegerlendirme, new TypeToken<List<SikayetDegerlendirmeDTO>>() {
		}.getType());
	}

	@Transactional
	public void kaydet(SikayetDegerlendirmeDTO sikayetDegerlendirmeDTO) {
		SikayetDegerlendirme sikayetDegerlendirme = new SikayetDegerlendirme();
		sikayetDegerlendirme.setAd(sikayetDegerlendirmeDTO.getAd());
		sikayetDegerlendirme.setAktifPasif(sikayetDegerlendirmeDTO.getAktifPasif());
		sikayetDegerlendirmeRepository.save(sikayetDegerlendirme);
	}

	@Transactional(readOnly = true)
	public SikayetDegerlendirmeDTO sikayetDegerlendirmeGetir(Long id) {
		return modelMapper.map(sikayetDegerlendirmeRepository.getOne(id), SikayetDegerlendirmeDTO.class);
	}
	
	@Transactional
	public void guncelle(SikayetDegerlendirmeDTO sikayetDegerlendirmeDTO) {
		SikayetDegerlendirme sikayetDegerlendirme = new SikayetDegerlendirme();
		sikayetDegerlendirme.setAd(sikayetDegerlendirmeDTO.getAd());
		sikayetDegerlendirme.setAktifPasif(sikayetDegerlendirmeDTO.getAktifPasif());
		sikayetDegerlendirme.setId(sikayetDegerlendirmeDTO.getId());
		sikayetDegerlendirmeRepository.save(sikayetDegerlendirme);
	}

}
