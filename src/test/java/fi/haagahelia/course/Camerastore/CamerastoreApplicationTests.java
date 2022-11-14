package fi.haagahelia.course.Camerastore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import fi.haagahelia.course.Camerastore.web.OrderController;
import fi.haagahelia.course.Camerastore.web.ProductController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class CamerastoreApplicationTests {
	
	/*
	 * Testing for that the controllers are functioning right
	 */
	
	@Autowired
	private OrderController orderController;
	
	@Autowired
	private ProductController productController;
	
	@Test
	public void contextLoads() throws Exception {
		assertThat(orderController).isNotNull();
		assertThat(productController).isNotNull();
		
	}

}
