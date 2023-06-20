package LOCMNS.demo;

import javax.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.TimeZone;

@SpringBootApplication
@EnableJpaAuditing
public class LocmnsApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(LocmnsApplication.class, args);
	}
	@PostConstruct
	public void init(){
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(LocmnsApplication.class);
	}
}
