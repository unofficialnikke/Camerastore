package fi.haagahelia.course.Camerastore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.course.Camerastore.domain.Product;
import fi.haagahelia.course.Camerastore.domain.ProductRepository;

@SpringBootApplication
public class CamerastoreApplication {
	private static final Logger log = LoggerFactory.getLogger(CamerastoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(CamerastoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner productDemo(ProductRepository prepository) {
		return (args) -> {
			log.info("few products");
			prepository.save(new Product("Nikon", "Z6 II", "2095,00 €", "4354366"));
			prepository.save(new Product("Canon", "R3", "6250,00 €", "3463463"));
			prepository.save(new Product("Sony", "A7 IV", "2850,00 €", "5675677"));
			
			log.info("fetech all products");
			for (Product product : prepository.findAll()) {
				log.info(product.toString());
			}
		};
	}

}
