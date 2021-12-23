package tr.gov.*****.*****essp*****.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.gov.*****.*****essp*****.model.entity.Duyuru;

@Repository
public interface DuyuruRepository extends JpaRepository<Duyuru, Long> {
}
