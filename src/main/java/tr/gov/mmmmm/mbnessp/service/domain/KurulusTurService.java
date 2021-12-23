package tr.gov.*****.*****essp*****.service.domain;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tr.gov.*****.*****essp*****.model.dto.KurulusTurDTO;
import tr.gov.*****.*****essp*****.model.entity.KurulusTur;
import tr.gov.*****.*****essp*****.repository.KurulusTurRepository;

@Service
public class KurulusTurService {

	private @Autowired ModelMapper modelMapper;
	private @Autowired KurulusTurRepository kurulusTurRepository;

	@Transactional(readOnly = true)
	public List<KurulusTurDTO> findAll() {
		List<KurulusTur> kurulusTur = kurulusTurRepository.findAll();
		return modelMapper.map(kurulusTur, new TypeToken<List<KurulusTurDTO>>() {}.getType());

	}

	@Transactional
	public void kaydet(KurulusTurDTO kurulusTurDTO) {
		KurulusTur kurulusTur = new KurulusTur();
		kurulusTur.setAd(kurulusTurDTO.getAd());
		kurulusTur.setAktifPasif(kurulusTurDTO.getAktifPasif());
		kurulusTurRepository.save(kurulusTur);
	}

	@Transactional(readOnly = true)
	public KurulusTurDTO getir(Long id) {
		return modelMapper.map(kurulusTurRepository.getOne(id), KurulusTurDTO.class);
	}
	
	@Transactional
	public void guncelle(KurulusTurDTO kurulusTurDTO) {
		KurulusTur kurulusTur = new KurulusTur();
		kurulusTur.setId(kurulusTurDTO.getId());
		kurulusTur.setAd(kurulusTurDTO.getAd());
		kurulusTur.setAktifPasif(kurulusTurDTO.getAktifPasif());
		kurulusTurRepository.save(kurulusTur);
	}
	
}
