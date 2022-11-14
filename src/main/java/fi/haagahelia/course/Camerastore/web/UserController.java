package fi.haagahelia.course.Camerastore.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import fi.haagahelia.course.Camerastore.domain.Signup;
import fi.haagahelia.course.Camerastore.domain.User;
import fi.haagahelia.course.Camerastore.domain.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository UserRepo;
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/signup")
	public String createAccount(Model model) {
		model.addAttribute("signup", new Signup());
		return "signuppage";
	}
	
	@PostMapping("/createaccount")
	public String create(@Valid @ModelAttribute("signup") Signup signup, BindingResult bindingResult) {
		
		if (!bindingResult.hasErrors()) {

			if (signup.getPassword().equals(signup.getCheckPassword())) {
				String password = signup.getPassword();
				BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
				String hash = bc.encode(password);
				
				User newUser = new User();
				newUser.setPasswordHash(hash);
				newUser.setUsername(signup.getUsername());
				newUser.setRole("USER");
				
				if (UserRepo.findByUsername(signup.getUsername()) == null) {
					UserRepo.save(newUser);
				} else {
					bindingResult.rejectValue("checkPassword", "err.passCheck", "Käyttäjänimi on jo käytössä");
					return "signuppage";
				}
					
			} else {
				bindingResult.rejectValue("checkPassword", "err.passCheck", "Salasanat eivät täsmää.");
				return "signuppage";
			}

		} else {
			return "signuppage";
		}
		
		return "redirect:/login";
	}
}
