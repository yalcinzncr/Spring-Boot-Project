package tr.gov.*****.*****essp*****.service.domain;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tr.gov.*****.*****essp*****.exception.ApiException;
import tr.gov.*****.*****essp*****.model.dto.SikayetTurDTO;
import tr.gov.*****.*****essp*****.model.entity.Mudurluk;
import tr.gov.*****.*****essp*****.model.entity.SikayetTur;
import tr.gov.*****.*****essp*****.repository.MudurlukRepository;
import tr.gov.*****.*****essp*****.repository.SikayetTurRepository;

@Service
public class SikayetTurService {

	private @Autowired ModelMapper modelMapper;
	private @Autowired SikayetTurRepository sikayetTurRepository;
	private @Autowired MudurlukRepository mudurlukRepository;

	@Transactional(readOnly = true)
	public List<SikayetTurDTO> findAll() {
		List<SikayetTur> sikayetTur = sikayetTurRepository.findAll();
		return modelMapper.map(sikayetTur, new TypeToken<List<SikayetTurDTO>>() {}.getType());

	}

	@Transactional
	public void kaydet(SikayetTurDTO sikayetTurDTO) {
		Mudurluk persitentMudurluk = mudurlukRepository.findById(sikayetTurDTO.getMudurluk().getId()).orElseThrow(() -> new ApiException("Müdürlük bulunamadı!"));
		SikayetTur sikayetTur = new SikayetTur();
		sikayetTur.setAd(sikayetTurDTO.getAd());
		sikayetTur.setAktifPasif(sikayetTurDTO.getAktifPasif());
		sikayetTur.setMudurluk(persitentMudurluk);
		sikayetTurRepository.save(sikayetTur);
	}

	@Transactional(readOnly = true)
	public SikayetTurDTO sikayetTurGetir(Long id) {
		return modelMapper.map(sikayetTurRepository.getOne(id), SikayetTurDTO.class);
	}
	
	@Transactional
	public void guncelle(SikayetTurDTO sikayetTurDTO) {
		Mudurluk persitentMudurluk = mudurlukRepository.findById(sikayetTurDTO.getMudurluk().getId()).orElseThrow(() -> new ApiException("Müdürlük bulunamadı!"));
		SikayetTur sikayetTur = new SikayetTur();
		sikayetTur.setId(sikayetTurDTO.getId());
		sikayetTur.setAd(sikayetTurDTO.getAd());
		sikayetTur.setAktifPasif(sikayetTurDTO.getAktifPasif());
		sikayetTur.setMudurluk(persitentMudurluk);
		sikayetTurRepository.save(sikayetTur);
	}

}
