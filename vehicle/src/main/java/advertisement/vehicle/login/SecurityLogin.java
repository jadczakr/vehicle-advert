package advertisement.vehicle.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityLogin {

	
	@GetMapping("/login")
	public String login()
	{
		
		return "login";
	}
	
	@GetMapping("/acces-denied")
	public String accesDenied()
	{
		return "acces-denied";
	}
}
