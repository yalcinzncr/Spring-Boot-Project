package tr.gov.*****.*****essp*****.model.entity.reference;

import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import tr.gov.*****.*****essp*****.deserializer.AktifPasifDeserializer;

@JsonFormat(shape = Shape.OBJECT)
@JsonDeserialize(using = AktifPasifDeserializer.class)
public enum AktifPasif {

	AKTIF(1, "Aktif"), PASIF(0, "Pasif");

	private int id;
	private String label;

	private AktifPasif(int id, String label) {
		this.id = id;
		this.label = label;
	}

	public int getId() {
		return id;
	}

	public String getLabel() {
		return label;
	}

	public static AktifPasif decode(final int id) {
		return Stream.of(AktifPasif.values()).filter(targetEnum -> targetEnum.getId() == id).findFirst().orElse(null);
	}

}
