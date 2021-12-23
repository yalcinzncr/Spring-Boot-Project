package tr.gov.*****.*****essp*****.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import tr.gov.*****.*****essp*****.model.entity.SikayetDegerlendirme;

@Repository
public interface SikayetDegerlendirmeRepository extends JpaRepository<SikayetDegerlendirme, Long>, JpaSpecificationExecutor<SikayetDegerlendirme> {
}
