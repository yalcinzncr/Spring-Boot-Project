package tr.gov.*****.*****essp*****.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import tr.gov.*****.*****essp*****.model.entity.Mudurluk;

@Repository
public interface MudurlukRepository extends JpaRepository<Mudurluk, Long>, JpaSpecificationExecutor<Mudurluk> {
}
