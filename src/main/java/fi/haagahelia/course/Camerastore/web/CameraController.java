package fi.haagahelia.course.Camerastore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fi.haagahelia.course.Camerastore.domain.ProductRepository;

@Controller
public class CameraController {
	 
	@Autowired
	private ProductRepository prepository;
	
	@RequestMapping(value={"/", "/home"})
	public String cameraStore(Model model) {
		model.addAttribute("products", prepository.findAll());
		return "productlist";
	}
}
