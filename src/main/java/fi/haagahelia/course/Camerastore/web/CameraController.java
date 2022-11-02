package fi.haagahelia.course.Camerastore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.haagahelia.course.Camerastore.domain.ConditionRepository;
import fi.haagahelia.course.Camerastore.domain.Product;
import fi.haagahelia.course.Camerastore.domain.ProductRepository;
import fi.haagahelia.course.Camerastore.domain.StatusRepository;

@Controller
public class CameraController {	 
	@Autowired
	private ProductRepository prepository;	
	@Autowired
	private ConditionRepository crepository;
	@Autowired
	private StatusRepository srepository;
	
	// kamerasovelluksen kotisivu, joka listaa kaikki tuotteet
	@RequestMapping(value={"/", "/home"})
	public String cameraStore(Model model) {
		model.addAttribute("products", prepository.findAll());
		return "productlist";
	}
	// toiminto tuotteen poistamiselle
	@GetMapping("/delete/{id}")
	public String deleteProduct(@PathVariable("id") Long productId, Model model) {
		prepository.deleteById(productId);
		return "redirect:../home";
	}
	// toiminto uusien tuotteiden lisäämiselle
	@RequestMapping(value = "/add")
	public String addProduct(Model model) {
		model.addAttribute("product", new Product());
		model.addAttribute("conditions", crepository.findAll());
		model.addAttribute("statuses", srepository.findAll());
		return "addproduct";
	}
	// toiminto tuotteiden muokkaamista varten
	@GetMapping("/edit/{id}")
	public String editProduct(@PathVariable("id") Long productId, Model model) {
		model.addAttribute("product", prepository.findById(productId));
		model.addAttribute("conditions", crepository.findAll());
		model.addAttribute("statuses", srepository.findAll());	
		return "editproduct";
	}
	// toiminto, joka tallentaa muutetut tuotetiedot
	@PostMapping("/save")
	public String save(Product product) {
		prepository.save(product);
		return "redirect:home";
	}
	// toiminto vie tuotesivulle, jossa on enemmän informaatiota tuotteesta
	@GetMapping("/product/{id}")
	public String productPage(@PathVariable("id") Long productId, Model model) {
		model.addAttribute("product", prepository.findById(productId));
		model.addAttribute("conditions", crepository.findAll());
		model.addAttribute("statuses", srepository.findAll());	
		return "productpage";
	}
	
}
