package fi.haagahelia.course.Camerastore.domain;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Signup {
	
	/*
	 * Class for the signup. It gets the values from the inputfields of the signup 
	 * html page and saves them into the UseRepository
	 */
	
	@NotEmpty
	@Size(min=4, max=25)
	private String username = "";
	
	@NotEmpty
	@Size(min=6, max=30)
	private String password = "";
	
	@NotEmpty
	@Size(min=6, max=30)
	private String checkPassword = "";
	
	@NotEmpty
	private String role = "USER";

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getCheckPassword() {
		return checkPassword;
	}

	public void setCheckPassword(String checkPassword) {
		this.checkPassword = checkPassword;
	}
	
	
}
