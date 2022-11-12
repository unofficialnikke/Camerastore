package fi.haagahelia.course.Camerastore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

	/*
	 * This method shows the product page for the specific product and lists
	 * all the data of it. From this page user can also make and order of the product
	 */
		@RequestMapping(value = "/product/{id}")
		public String productPage(@PathVariable("id") Long productId, Model model) {
			model.addAttribute("product", ProductRepo.findById(productId).get());
			return "productpage";
		}
		/*
		 * This method is for ordering products. It can be accessed through
		 * product pages and user can insert their order informations on this page
		 */
		@RequestMapping(value = "/order/{id}")
		public String orderPage(@PathVariable("id") Long productId, Model model) {
			model.addAttribute("order", new Order());
			model.addAttribute("product", ProductRepo.findById(productId).get());	
			return "orderpage";
		}
		/*
		 * This method places and saves the order and redirects the user to the confirm page
		 * It gets the id through the PathVariable
		 */
		@PostMapping("/placeorder/{id}")
		public String placeorderPage(@PathVariable("id") Long productId, Order order, Model model) {
			OrderRepo.save(order);
			model.addAttribute("product", ProductRepo.findById(productId).get());
			return "redirect:/confirm/" + productId;
		}
		/*
		 * This is the method to show the confirm page and it includes order and product details as well
		 * From this page user can return back to homepage
		 */
		
		@RequestMapping(value = "/confirm/{id}")
		public String confirmPage(@PathVariable("id") Long productId, String category, Model model)  {
			model.addAttribute("orders", OrderRepo.findAll());
			model.addAttribute("product", ProductRepo.findById(productId).get());
			return "confirmpage";
		}
		
		/*
		 * This is a sneaky method to delete the product from the productlist and it also deletes the
		 * order details that are show on the confirm page. It then redirects back to homepage
		 * It deletes the order details because in confirm page it would then list all the orders that
		 * have been made in the camerastore. So to only show the most recent order details on the confirm
		 * page I decided to make a method that always deletes the previous order details
		 */
		
		@GetMapping("/clear/{id}")
		public String deleteProduct(@PathVariable("id") Long productId, Order order, Model model) {
			ProductRepo.deleteById(productId);
			OrderRepo.deleteAll();
			return "redirect:../home";
			}
}
