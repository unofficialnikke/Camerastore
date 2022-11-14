package fi.haagahelia.course.Camerastore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.course.Camerastore.domain.Condition;
import fi.haagahelia.course.Camerastore.domain.ConditionRepository;
import fi.haagahelia.course.Camerastore.domain.OrderRepository;
import fi.haagahelia.course.Camerastore.domain.Product;
import fi.haagahelia.course.Camerastore.domain.ProductRepository;
import fi.haagahelia.course.Camerastore.domain.Status;
import fi.haagahelia.course.Camerastore.domain.StatusRepository;
import fi.haagahelia.course.Camerastore.domain.User;
import fi.haagahelia.course.Camerastore.domain.UserRepository;

@SpringBootApplication
public class CamerastoreApplication {
	private static final Logger log = LoggerFactory.getLogger(CamerastoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(CamerastoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner productDemo(ProductRepository ProductRepo, ConditionRepository ConditionRepo, 
										StatusRepository StatusRepo, UserRepository UserRepo, OrderRepository OrderRepo) {
		return (args) -> {
			
			/*
			 * Here I have added the Conditions and Statuses the admin can choose when adding or editing products
			 */
			 
			/*
			log.info("save the product conditions");
			ConditionRepo.save(new Condition("A"));
			ConditionRepo.save(new Condition("B"));
			ConditionRepo.save(new Condition("C"));
			ConditionRepo.save(new Condition("D"));
			ConditionRepo.save(new Condition("E"));
			
			log.info("save the product status");
			StatusRepo.save(new Status("Uusi"));
			StatusRepo.save(new Status("Käytetty"));	
			*/
			
			/*
			 * Here are a few example products I created to show on the camerastore 
			 */
				
			/*
			log.info("few products");
			ProductRepo.save(new Product("Nikon Z6 II", "2095,00", "4354366", "Hieno tuote", "Mikrojärjestelmäkamera", 
					ConditionRepo.findByName("A").get(0), StatusRepo.findByName("Uusi").get(0)));
			ProductRepo.save(new Product("Canon 5D Mark IV", "4250,00", "3463463", "Huono tuote", "Peilijärjestelmäkamera", 
					ConditionRepo.findByName("B").get(0), StatusRepo.findByName("Käytetty").get(0)));
			ProductRepo.save(new Product("Sony A7 IV", "2850,00", "5675677", "Huonoin tuote", "Mikrojärjestelmäkamera", 
					ConditionRepo.findByName("A").get(0), StatusRepo.findByName("Uusi").get(0)));
			*/
			
			/*
			 * A few users added into the UserRepository. Admin can access everywhere on this app while user
			 * can only view the products and make orders
			 */
			
			/*
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			UserRepo.save(user1);
			UserRepo.save(user2);
			
			log.info("fetch all products");
			for (Product product : ProductRepo.findAll()) {
				log.info(product.toString());
			}
			*/
		}; 
		
	}
			
}
