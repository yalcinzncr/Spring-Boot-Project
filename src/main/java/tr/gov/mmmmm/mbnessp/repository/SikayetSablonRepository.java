package tr.gov.*****.*****essp*****.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import tr.gov.*****.*****essp*****.model.entity.SikayetSablon;

@Repository
public interface SikayetSablonRepository extends JpaRepository<SikayetSablon, Long>, JpaSpecificationExecutor<SikayetSablon> {
}
