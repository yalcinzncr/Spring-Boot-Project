package tr.gov.*****.*****essp*****.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import tr.gov.*****.*****essp*****.model.entity.KurulusTur;

@Repository
public interface KurulusTurRepository extends JpaRepository<KurulusTur, Long>, JpaSpecificationExecutor<KurulusTur> {
}
