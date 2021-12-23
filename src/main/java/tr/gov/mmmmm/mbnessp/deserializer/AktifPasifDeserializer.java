package tr.gov.*****.*****essp*****.deserializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import tr.gov.*****.*****essp*****.model.entity.reference.AktifPasif;

public class AktifPasifDeserializer extends StdDeserializer<AktifPasif> {

	private static final long serialVersionUID = 1L;

	protected AktifPasifDeserializer() {
		this(null);
	}

	protected AktifPasifDeserializer(Class<?> vc) {
		super(vc);
	}

	@Override
	public AktifPasif deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {

		JsonNode node = p.getCodec().readTree(p);

		if (node.has("id")) {
			return AktifPasif.decode(Integer.decode(node.get("id").asText()));
		}

		return AktifPasif.decode(Integer.decode(node.asText()));
	}

}
