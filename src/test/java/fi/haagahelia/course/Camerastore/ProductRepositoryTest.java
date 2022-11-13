package fi.haagahelia.course.Camerastore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import fi.haagahelia.course.Camerastore.domain.Condition;
import fi.haagahelia.course.Camerastore.domain.Product;
import fi.haagahelia.course.Camerastore.domain.ProductRepository;
import fi.haagahelia.course.Camerastore.domain.Status;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ProductRepositoryTest {

	@Autowired
	private ProductRepository ProductRepo;
	
	@Test
	public void findByNameShouldReturnBook() {
		List<Product> products = ProductRepo.findByName("Nikon Z6 II");
		
		assertThat(products).hasSize(1);
		assertThat(products.get(0).getCategory()).isEqualTo("Mikrojärjestelmäkamera");	
	}
	
	@Test
	public void createNewProduct() {
		Product product = new Product("Nikon Z50", "950", "546548", "Pieni kamera", 
					"Mikrojärjestelmäkamera", new Condition("Käytetty"), new Status("B"));
		ProductRepo.save(product);
		assertThat(product.getId()).isNotNull();
	}
	
	@Test
	public void deleteNewProduct() {
		List<Product> products = ProductRepo.findByName("Nikon Z6 II");
		Product product = products.get(0);
		ProductRepo.delete(product);
		List<Product> newProducts = ProductRepo.findByName("Nikon Z6 II");
		assertThat(newProducts).hasSize(0);
	}
}
