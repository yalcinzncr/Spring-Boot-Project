package tr.gov.*****.*****essp*****.deserializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import tr.gov.*****.*****essp*****.model.entity.reference.SikayetDurum;

public class SikayetDurumDeserializer extends StdDeserializer<SikayetDurum> {

	private static final long serialVersionUID = 1L;

	protected SikayetDurumDeserializer() {
		this(null);
	}

	protected SikayetDurumDeserializer(Class<?> vc) {
		super(vc);
	}

	@Override
	public SikayetDurum deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {

		JsonNode node = p.getCodec().readTree(p);

		if (node.has("id")) {
			return SikayetDurum.decode(Integer.decode(node.get("id").asText()));
		}

		return SikayetDurum.decode(Integer.decode(node.asText()));
	}

}
