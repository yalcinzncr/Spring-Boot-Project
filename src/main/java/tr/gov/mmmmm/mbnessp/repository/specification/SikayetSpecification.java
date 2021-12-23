package tr.gov.*****.*****essp*****.repository.specification;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import tr.gov.*****.*****essp*****.model.entity.Sikayet;
import tr.gov.*****.*****essp*****.model.entity.metamodel.SikayetMM;
import tr.gov.*****.*****essp*****.model.entity.reference.Kanal;
import tr.gov.*****.*****essp*****.model.entity.reference.SikayetDurum;

public final class SikayetSpecification {

	private SikayetSpecification() {
	}

	public static Specification<Sikayet> kanalEqual(Kanal kanal) {
		return (root, query, cb) -> cb.equal(root.get(SikayetMM.KANAL), kanal);
	}

	public static Specification<Sikayet> durumIn(List<SikayetDurum> durumList) {
		return (root, query, cb) -> root.get(SikayetMM.DURUM).in(durumList);
	}
	
}
