package ada.wm2.carrental.controller;

import ada.wm2.carrental.service.AuthenticationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/auth")
public class AuthenticationController
{
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	AuthenticationService authService;
	
	// ----- GET REQUESTS -----
	
	@GetMapping
	public String getLoginPage(Model model)
	{
		return "login";
	}
	
	@GetMapping("/register")
	public String getRegistrationPage(Model model)
	{
		return "register";
	}
	
	@GetMapping("/logout")
	public String logout()
	{
		if (authService.logout())
		{
			logger.info("Logout Attempt :: Successful");
		}
		else
		{
			logger.info("Logout Attempt :: Failed");
		}
		
		return "redirect:/";
	}
	
	// ----- POST REQUESTS -----
	
	@PostMapping("/login")
	public String login(@RequestParam String email,
	                    @RequestParam String password)
	{
		logger.info("Login Attempt :: email = {}, pass = {}", email, password);
		
		if (authService.login(email, password))
		{
			logger.info("Login Attempt :: Successful");
			return "redirect:/";
		}
		else
		{
			logger.error("Login Attempt :: Failed");
			return "redirect:/auth";
		}
	}
	
	@PostMapping("/register")
	public String register(@RequestParam String email,
	                       @RequestParam String password,
	                       @RequestParam String name)
	{
		logger.info("Registration attempt :: email = {}, pass = {}", email, password);
		
		if (authService.register(email, name, password))
		{
			logger.info("Registration Attempt :: Successful");
		}
		else
		{
			logger.error("Registration Attempt :: Failed");
		}
		
		return "redirect:/auth";
	}
}
