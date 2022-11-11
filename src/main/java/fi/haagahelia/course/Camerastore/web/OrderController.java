package fi.haagahelia.course.Camerastore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fi.haagahelia.course.Camerastore.domain.Order;
import fi.haagahelia.course.Camerastore.domain.OrderRepository;
import fi.haagahelia.course.Camerastore.domain.ProductRepository;

@Controller
public class OrderController {
	@Autowired
	private ProductRepository ProductRepo;
	@Autowired
	private OrderRepository OrderRepo;

	// toiminto vie tuotesivulle, jossa on enemmän informaatiota tuotteesta
		@RequestMapping(value = "/product/{id}")
		public String productPage(@PathVariable("id") Long productId, Model model) {
			model.addAttribute("product", ProductRepo.findById(productId).get());
			return "productpage";
		}
		
		@RequestMapping(value = "/order/{id}")
		public String orderPage(@PathVariable("id") Long productId, Model model) {
			model.addAttribute("orders", new Order());
			model.addAttribute("product", ProductRepo.findById(productId).get());	
			return "orderpage";
		}
		
		@PostMapping("/confirm")
		public String confirm(Order order, Model model) {
			OrderRepo.save(order);
			return "redirect:confirm";
		}
		
		@RequestMapping(value = "/confirm")
		public String confirmPage(Model model){
			model.addAttribute("orders", OrderRepo.findAll());
			return "confirmpage";
		}
}
