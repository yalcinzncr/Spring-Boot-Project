package tr.gov.*****.*****essp*****.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import tr.gov.*****.*****essp*****.model.entity.reference.AktifPasif;
import tr.gov.*****.*****essp*****.model.entity.reference.BankaKullaniciRol;
import tr.gov.*****.*****essp*****.model.entity.reference.SikayetDurum;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE",
				"OPTIONS");
	}

	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(new Converter<String, AktifPasif>() {
			@Override
			public AktifPasif convert(String id) {
				return AktifPasif.decode(Integer.valueOf(id));
			}
		});
		
	    registry.addConverter(new Converter<String, SikayetDurum>() {
	        @Override
	        public SikayetDurum convert(String value) {
	          return SikayetDurum.decode(Integer.decode(value));
	        }
	    });
	    
	    registry.addConverter(new Converter<String, BankaKullaniciRol>() {
	        @Override
	        public BankaKullaniciRol convert(String value) {
	          return BankaKullaniciRol.decode(Integer.decode(value));
	        }
	    });
	}

}
