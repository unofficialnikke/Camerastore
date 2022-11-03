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
	public CommandLineRunner productDemo(ProductRepository ProductRepo, ConditionRepository ConditionRepo, 
										StatusRepository StatusRepo) {
		return (args) -> {
			
			log.info("save the product conditions");
			ConditionRepo.save(new Condition("A"));
			ConditionRepo.save(new Condition("B"));
			ConditionRepo.save(new Condition("C"));
			ConditionRepo.save(new Condition("D"));
			ConditionRepo.save(new Condition("E"));
			
			log.info("save the product status");
			StatusRepo.save(new Status("Uusi"));
			StatusRepo.save(new Status("Käytetty"));
			
			log.info("few products");
			ProductRepo.save(new Product("Nikon Z6 II", "2095,00 €", "4354366", "Hieno tuote", "Mikrojärjestelmäkamera", 
					ConditionRepo.findByName("A").get(0), StatusRepo.findByName("Uusi").get(0)));
			ProductRepo.save(new Product("Canon 5D Mark IV", "4250,00 €", "3463463", "Huono tuote", "Peilijärjestelmäkamera", 
					ConditionRepo.findByName("B").get(0), StatusRepo.findByName("Käytetty").get(0)));
			ProductRepo.save(new Product("Sony A7 IV", "2850,00 €", "5675677", "Huonoin tuote", "Mikrojärjestelmäkamera", 
					ConditionRepo.findByName("A").get(0), StatusRepo.findByName("Uusi").get(0)));

			
			log.info("fetch all products");
			for (Product product : ProductRepo.findAll()) {
				log.info(product.toString());
			}
		};
	}

}
