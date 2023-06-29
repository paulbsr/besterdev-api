package ie.bester.besterdevapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BesterdevApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BesterdevApiApplication.class, args);
		System.out.println("besterdev-api is nou aktief!");
	}

}
