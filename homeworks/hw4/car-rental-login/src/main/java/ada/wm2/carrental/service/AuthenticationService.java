package ada.wm2.carrental.service;

import ada.wm2.carrental.bean.UserBean;
import ada.wm2.carrental.entity.User;
import ada.wm2.carrental.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class AuthenticationService
{
	private String loggedInUserEmail = null;
	
	@Autowired
	UserRepository userRepo;
	
	public boolean login(String email, String password)
	{
		password = hash(password);
		
		if (userRepo.existsByEmailAndPassword(email, password))
		{
			loggedInUserEmail = email;
			return true;
		}
		return false;
	}
	
	public boolean register(String email, String name, String password)
	{
		password = hash(password);
		
		if (userRepo.existsByEmail(email))
		{
			return false;
		}
		
		User newUser = new User(email,password, name);
		userRepo.save(newUser);
		
		return true;
	}
	
	public boolean logout()
	{
		if (isUserLoggedIn())
		{
			loggedInUserEmail = null;
			return true;
		}
		
		return false;
	}
	
	public boolean isUserLoggedIn()
	{
		return loggedInUserEmail != null;
	}
	
	public UserBean getLoggedInUser()
	{
		if (!isUserLoggedIn()) return null;
		return new UserBean(userRepo.findByEmail(loggedInUserEmail));
	}
	
	private String hash(String plain)
	{
		try
		{
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			byte[] hash = md.digest(plain.getBytes(StandardCharsets.UTF_8));
			StringBuilder hashedString = new StringBuilder();
			
			for (byte b : hash) hashedString.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
			
			return hashedString.toString();
			
		} catch (NoSuchAlgorithmException e)
		{
			e.printStackTrace();
		}
		
		return plain;
	}
}
