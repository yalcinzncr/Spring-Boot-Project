package tr.gov.*****.*****essp*****.service.domain;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tr.gov.*****.*****essp*****.exception.ApiException;
import tr.gov.*****.*****essp*****.model.dto.KurulusDTO;
import tr.gov.*****.*****essp*****.model.entity.Kurulus;
import tr.gov.*****.*****essp*****.model.entity.KurulusTur;
import tr.gov.*****.*****essp*****.repository.KurulusRepository;
import tr.gov.*****.*****essp*****.repository.KurulusTurRepository;

@Service
public class KurulusService {

	private @Autowired ModelMapper modelMapper;
	private @Autowired KurulusRepository kurulusRepository;
	private @Autowired KurulusTurRepository kurulusTurRepository;

	@Transactional(readOnly = true)
	public List<KurulusDTO> findAll() {
		List<Kurulus> kurulus = kurulusRepository.findAll();
		return modelMapper.map(kurulus, new TypeToken<List<KurulusDTO>>() {}.getType());

	}

	@Transactional
	public void kaydet(KurulusDTO kurulusDTO) {
		KurulusTur persistentKurulusTur = kurulusTurRepository.findById(kurulusDTO.getTur().getId()).orElseThrow(() -> new ApiException("Kuruluş Türü bulunamadı"));
		Kurulus kurulus = new Kurulus();
		kurulus.setAd(kurulusDTO.getAd());
		kurulus.setAktifPasif(kurulusDTO.getAktifPasif());
		kurulus.setTur(persistentKurulusTur);
		kurulusRepository.save(kurulus);
	}

	@Transactional(readOnly = true)
	public KurulusDTO getir(Long id) {
		return modelMapper.map(kurulusRepository.getOne(id), KurulusDTO.class);
	}
	
	@Transactional
	public void guncelle(KurulusDTO kurulusDTO) {
		KurulusTur persistentKurulusTur = kurulusTurRepository.findById(kurulusDTO.getTur().getId()).orElseThrow(() -> new ApiException("Kuruluş Türü bulunamadı"));
		
		Kurulus kurulus = new Kurulus();
		kurulus.setId(kurulusDTO.getId());
		kurulus.setAd(kurulusDTO.getAd());
		kurulus.setAktifPasif(kurulusDTO.getAktifPasif());
		kurulus.setTur(persistentKurulusTur);
		kurulusRepository.save(kurulus);
	}
	
}
