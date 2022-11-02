package fi.haagahelia.course.Camerastore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fi.haagahelia.course.Camerastore.domain.ConditionRepository;
import fi.haagahelia.course.Camerastore.domain.Product;
import fi.haagahelia.course.Camerastore.domain.ProductRepository;

@Controller
public class CameraController {
	 
	@Autowired
	private ProductRepository prepository;
	
	@Autowired
	private ConditionRepository crepository;
	
	@RequestMapping(value={"/", "/home"})
	public String cameraStore(Model model) {
		model.addAttribute("products", prepository.findAll());
		return "productlist";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteProduct(@PathVariable("id") Long productId, Model model) {
		prepository.deleteById(productId);
		return "redirect:../home";
	}
	
	@RequestMapping(value = "/add")
	public String addProduct(Model model) {
		model.addAttribute("product", new Product());
		model.addAttribute("conditions", crepository.findAll());
		return "addproduct";
	}
	
	@PostMapping("/save")
	public String save(Product product) {
		prepository.save(product);
		return "redirect:home";
	}
}
