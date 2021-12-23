package tr.gov.*****.*****essp*****.service.domain;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tr.gov.*****.*****essp*****.exception.ApiException;
import tr.gov.*****.*****essp*****.model.dto.SikayetDTO;
import tr.gov.*****.*****essp*****.model.entity.Kurulus;
import tr.gov.*****.*****essp*****.model.entity.KurulusTur;
import tr.gov.*****.*****essp*****.model.entity.Sikayet;
import tr.gov.*****.*****essp*****.model.entity.SikayetAltKonu;
import tr.gov.*****.*****essp*****.model.entity.SikayetKonu;
import tr.gov.*****.*****essp*****.model.entity.SikayetTur;
import tr.gov.*****.*****essp*****.model.entity.reference.SikayetDurum;
import tr.gov.*****.*****essp*****.repository.KurulusRepository;
import tr.gov.*****.*****essp*****.repository.KurulusTurRepository;
import tr.gov.*****.*****essp*****.repository.SikayetAltKonuRepository;
import tr.gov.*****.*****essp*****.repository.SikayetKonuRepository;
import tr.gov.*****.*****essp*****.repository.SikayetRepository;
import tr.gov.*****.*****essp*****.repository.SikayetTurRepository;
import tr.gov.*****.*****essp*****.repository.specification.SikayetSpecification;

@Service
public class SikayetService {

  private @Autowired ModelMapper modelMapper;
  private @Autowired SikayetRepository sikayetRepository;
  private @Autowired SikayetTurRepository  sikayetTurRepository;
  private @Autowired SikayetKonuRepository sikayetKonuRepository;
  private @Autowired SikayetAltKonuRepository sikayetAltKonuRepository;
  private @Autowired KurulusTurRepository kurulusTurRepository;
  private @Autowired KurulusRepository kurulusRepository;

  @Transactional(readOnly = true)
  public Page<SikayetDTO> findAll(Pageable pageable) {

    Page<Sikayet> sikayetPage = sikayetRepository.findAll(pageable);

    List<SikayetDTO> sikayetDTOList = modelMapper.map(sikayetPage.getContent(), new TypeToken<List<SikayetDTO>>() {}.getType());

    return new PageImpl<>(sikayetDTOList, pageable, sikayetPage.getTotalElements());

  }
  
  @Transactional(readOnly = true)
  public Page<SikayetDTO> findAllBySikayetDurum(List<SikayetDurum> durumList , Pageable pageable) {

	Page<Sikayet> sikayetPage = sikayetRepository.findAll(SikayetSpecification.durumIn(durumList), pageable);

    List<SikayetDTO> sikayetDTOList = modelMapper.map(sikayetPage.getContent(), new TypeToken<List<SikayetDTO>>() {}.getType());

    return new PageImpl<>(sikayetDTOList, pageable, sikayetPage.getTotalElements());

  }
  
	@Transactional(readOnly = true)
	public SikayetDTO sikayetGetir(Long id) {
		return modelMapper.map(sikayetRepository.findById(id), SikayetDTO.class);
	}
	
	@Transactional
	public void guncelleSikayetDurum(SikayetDTO sikayetDTO) {
		
		SikayetTur persitentsikayetTur = sikayetTurRepository.findById(sikayetDTO.getTur().getId()).orElseThrow(() -> new ApiException("Şikayet Türü bulunamadı!"));
	    SikayetKonu persistentSikayetKonu = sikayetKonuRepository.findById(sikayetDTO.getKonu().getId()).orElseThrow(() -> new ApiException("Şikayet Konusu bulunamadı!"));
	    SikayetAltKonu persistentSikayetAltKonu = sikayetAltKonuRepository.findById(sikayetDTO.getAltKonu().getId()).orElseThrow(() -> new ApiException("Şikayet Alt Konusu bulunamadı!"));
	    KurulusTur persistentKurulusTur = kurulusTurRepository.findById(sikayetDTO.getKurulusTur().getId()).orElseThrow(() -> new ApiException("Kuruluş Türü bulunamadı"));
	    Kurulus persistentKurulus = kurulusRepository.findById(sikayetDTO.getKurulus().getId()).orElseThrow(() -> new ApiException("Kuruluş bulunamadı!"));
		
		Sikayet sikayet = new Sikayet();
		sikayet.setId(sikayetDTO.getId());
		sikayet.setTckn(sikayetDTO.getTckn());
		sikayet.setAdSoyad(sikayetDTO.getAdSoyad());
		sikayet.setEposta(sikayetDTO.getEposta());
		sikayet.setCeptel(sikayetDTO.getCeptel());
		sikayet.setAdres(sikayetDTO.getAdres());
		sikayet.setKvkkPaylasim(sikayetDTO.getKvkkPaylasim());
		sikayet.setTur(persitentsikayetTur);
		sikayet.setKonu(persistentSikayetKonu);
		sikayet.setAltKonu(persistentSikayetAltKonu);
		sikayet.setKurulusTur(persistentKurulusTur);
		sikayet.setKurulus(persistentKurulus);
		
		sikayetRepository.save(sikayet);
	}

}
