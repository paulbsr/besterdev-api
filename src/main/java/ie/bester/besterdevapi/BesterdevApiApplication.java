package ie.bester.besterdevapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class BesterdevApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BesterdevApiApplication.class, args);
		System.out.println("besterdev-api is nou aktief!");
	}

	@Configuration
	@EnableWebMvc
	public class WebConfig implements WebMvcConfigurer {
		@Override
		public void addCorsMappings(CorsRegistry registry) {
			registry.addMapping("/**")
					.allowedOrigins(
							"http://localhost:3000",
							"https://besterdev-ui-7acbd6898555.herokuapp.com/",
							"https://www.bester.ie")
					.allowedMethods("*");
		}
	}


}
