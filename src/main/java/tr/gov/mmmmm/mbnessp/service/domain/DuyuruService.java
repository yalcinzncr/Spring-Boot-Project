package tr.gov.*****.*****essp*****.service.domain;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tr.gov.*****.*****essp*****.model.dto.DuyuruDTO;
import tr.gov.*****.*****essp*****.model.entity.Duyuru;
import tr.gov.*****.*****essp*****.repository.DuyuruRepository;

@Service
public class DuyuruService {

	private @Autowired ModelMapper modelMapper;
	private @Autowired DuyuruRepository duyuruRepository;

	@Transactional(readOnly = true)
	public List<DuyuruDTO> findAll() {
		List<Duyuru> duyuru = duyuruRepository.findAll();
		return modelMapper.map(duyuru, new TypeToken<List<DuyuruDTO>>() {}.getType());

	}

	@Transactional
	public void kaydet(DuyuruDTO duyuruDTO) {
		Duyuru duyuru = new Duyuru();
		duyuru.setBaslik(duyuruDTO.getBaslik());
		duyuru.setIcerik(duyuruDTO.getIcerik());
		duyuru.setAktifPasif(duyuruDTO.getAktifPasif());
		duyuruRepository.save(duyuru);
	}

	@Transactional(readOnly = true)
	public DuyuruDTO getir(Long id) {
		return modelMapper.map(duyuruRepository.getOne(id), DuyuruDTO.class);
	}
	
	@Transactional
	public void guncelle(DuyuruDTO duyuruDTO) {
		Duyuru duyuru = new Duyuru();
		duyuru.setId(duyuruDTO.getId());
		duyuru.setBaslik(duyuruDTO.getBaslik());
		duyuru.setIcerik(duyuruDTO.getIcerik());
		duyuru.setAktifPasif(duyuruDTO.getAktifPasif());
		duyuruRepository.save(duyuru);
	}

}
