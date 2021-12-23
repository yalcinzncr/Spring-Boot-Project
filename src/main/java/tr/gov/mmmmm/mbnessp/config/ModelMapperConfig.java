package tr.gov.*****.*****essp*****.config;

import java.util.Objects;
import org.hibernate.collection.spi.PersistentCollection;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

  private Converter<String, String> stringTrimConverter = context -> {
    String source = context.getSource();
    if (Objects.isNull(source))
      return source;
    return source.trim();
  };

  @Bean
  public ModelMapper modelMapper() {

    ModelMapper mapper = new ModelMapper();
    mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    mapper.getConfiguration().setPropertyCondition(context -> !(context.getSource() instanceof PersistentCollection));

    mapper.createTypeMap(String.class, String.class).setConverter(stringTrimConverter);

    mapper.validate();

    return mapper;

  }

}
