package fi.haagahelia.course.Camerastore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.course.Camerastore.domain.Condition;
import fi.haagahelia.course.Camerastore.domain.ConditionRepository;
import fi.haagahelia.course.Camerastore.domain.Product;
import fi.haagahelia.course.Camerastore.domain.ProductRepository;
import fi.haagahelia.course.Camerastore.domain.Status;
import fi.haagahelia.course.Camerastore.domain.StatusRepository;

@SpringBootApplication
public class CamerastoreApplication {
	private static final Logger log = LoggerFactory.getLogger(CamerastoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(CamerastoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner productDemo(ProductRepository prepository, ConditionRepository crepository, StatusRepository srepository) {
		return (args) -> {
			
			log.info("save the product conditions");
			crepository.save(new Condition("A"));
			crepository.save(new Condition("B"));
			crepository.save(new Condition("C"));
			crepository.save(new Condition("D"));
			crepository.save(new Condition("E"));
			
			log.info("save the product status");
			srepository.save(new Status("Uusi"));
			srepository.save(new Status("Käytetty"));
			
			log.info("few products");
			prepository.save(new Product("Nikon", "Z6 II", "2095,00 €", "4354366", crepository.findByName("A").get(0), srepository.findByName("Uusi").get(0)));
			prepository.save(new Product("Canon", "R3", "6250,00 €", "3463463", crepository.findByName("A").get(0), srepository.findByName("Käytetty").get(0)));
			prepository.save(new Product("Sony", "A7 IV", "2850,00 €", "5675677", crepository.findByName("A").get(0), srepository.findByName("Uusi").get(0)));
			
			log.info("fetch all products");
			for (Product product : prepository.findAll()) {
				log.info(product.toString());
			}
		};
	}

}
