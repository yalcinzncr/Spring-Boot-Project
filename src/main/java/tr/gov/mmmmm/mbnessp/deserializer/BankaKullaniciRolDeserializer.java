package tr.gov.*****.*****essp*****.deserializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import tr.gov.*****.*****essp*****.model.entity.reference.BankaKullaniciRol;

public class BankaKullaniciRolDeserializer extends StdDeserializer<BankaKullaniciRol> {

	private static final long serialVersionUID = 1L;

	protected BankaKullaniciRolDeserializer() {
		this(null);
	}

	protected BankaKullaniciRolDeserializer(Class<?> vc) {
		super(vc);
	}

	@Override
	public BankaKullaniciRol deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {

		JsonNode node = p.getCodec().readTree(p);

		if (node.has("id")) {
			return BankaKullaniciRol.decode(Integer.decode(node.get("id").asText()));
		}

		return BankaKullaniciRol.decode(Integer.decode(node.asText()));
	}

}
