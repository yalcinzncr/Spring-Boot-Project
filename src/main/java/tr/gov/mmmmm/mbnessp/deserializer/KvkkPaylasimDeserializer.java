package tr.gov.*****.*****essp*****.deserializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import tr.gov.*****.*****essp*****.model.entity.reference.KvkkPaylasim;

public class KvkkPaylasimDeserializer extends StdDeserializer<KvkkPaylasim> {

  private static final long serialVersionUID = 1L;

  protected KvkkPaylasimDeserializer() {
    this(null);
  }

  protected KvkkPaylasimDeserializer(Class<?> vc) {
    super(vc);
  }

  @Override
  public KvkkPaylasim deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
    JsonNode node = p.getCodec().readTree(p);

    if (node.has("id")) {
      return KvkkPaylasim.decode(Integer.decode(node.get("id").asText()));
    }

    return KvkkPaylasim.decode(Integer.decode(node.asText()));
  }

}
