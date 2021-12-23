package tr.gov.*****.*****essp*****.service.domain;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tr.gov.*****.*****essp*****.model.dto.MudurlukDTO;
import tr.gov.*****.*****essp*****.model.entity.Mudurluk;
import tr.gov.*****.*****essp*****.repository.MudurlukRepository;

@Service
public class MudurlukService {

	private @Autowired ModelMapper modelMapper;
	private @Autowired MudurlukRepository mudurlukRepository;

	@Transactional(readOnly = true)
	public List<MudurlukDTO> findAll() {
		List<Mudurluk> mudurluk = mudurlukRepository.findAll();
		return modelMapper.map(mudurluk, new TypeToken<List<MudurlukDTO>>() {
		}.getType());
	}

	@Transactional
	public void kaydet(MudurlukDTO mudurlukDTO) {
		Mudurluk mudurluk = new Mudurluk();
		mudurluk.setAd(mudurlukDTO.getAd());
		mudurluk.setAktifPasif(mudurlukDTO.getAktifPasif());
		mudurlukRepository.save(mudurluk);
	}

	@Transactional(readOnly = true)
	public MudurlukDTO mudurlukGetir(Long id) {
		return modelMapper.map(mudurlukRepository.getOne(id), MudurlukDTO.class);
	}
	
	@Transactional
	public void guncelle(MudurlukDTO mudurlukDTO) {
		Mudurluk mudurluk = new Mudurluk();
		mudurluk.setAd(mudurlukDTO.getAd());
		mudurluk.setAktifPasif(mudurlukDTO.getAktifPasif());
		mudurluk.setId(mudurlukDTO.getId());
		mudurlukRepository.save(mudurluk);
	}

}
