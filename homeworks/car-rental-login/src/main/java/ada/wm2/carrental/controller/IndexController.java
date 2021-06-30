package ada.wm2.carrental.controller;

import ada.wm2.carrental.bean.CarBean;
import ada.wm2.carrental.bean.CustomerBean;
import ada.wm2.carrental.entity.Car;
import ada.wm2.carrental.entity.Customer;
import ada.wm2.carrental.service.AuthenticationService;
import ada.wm2.carrental.service.CarService;
import ada.wm2.carrental.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;

@Controller
public class IndexController
{
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	CarService carService;
	
	@Autowired
	AuthenticationService authService;
	
	
	// ----- GET REQUESTS -----
	
	@GetMapping
	public String getIndexPage(Model model)
	{
		if (isAccessingIllegally()) return "redirect:/auth";
		
		model = getUpdatedModel(model);
		
		return "welcome";
	}
	
	@GetMapping("new-customer")
	public String getCustomerAddPage(Model model)
	{
		if (isAccessingIllegally()) return "redirect:/auth";
		
		model.addAttribute("add", true);
		return "customerAddEdit";
	}
	
	@GetMapping("edit-customer/{customerId}")
	public String getCustomerEditPage(Model model, @PathVariable Integer customerId)
	{
		if (isAccessingIllegally()) return "redirect:/auth";
		
		CustomerBean customerBean = customerService.getCustomerById(customerId);
		model.addAttribute("add", false);
		model.addAttribute("customer", customerBean);
		return "customerAddEdit";
	}
	
	@GetMapping("new-car")
	public String getCarAddPage(Model model)
	{
		if (isAccessingIllegally()) return "redirect:/auth";
		
		model.addAttribute("add", true);
		return "carAddEdit";
	}
	
	@GetMapping("edit-car/{carId}")
	public String getCarEditPage(Model model, @PathVariable Integer carId)
	{
		if (isAccessingIllegally()) return "redirect:/auth";
		
		CarBean carBean = carService.getCarById(carId);
		model.addAttribute("add", false);
		model.addAttribute("car", carBean);
		return "carAddEdit";
	}
	
	@GetMapping("rent/{customerId}")
	public String getRentPage(Model model, @PathVariable Integer customerId)
	{
		if (isAccessingIllegally()) return "redirect:/auth";
		
		model = getUpdatedModel(model);
		
		Customer customer = new Customer(customerService.getCustomerById(customerId));
		model.addAttribute("customer", customer);
		return "rent";
	}
	
	// ----- POST REQUESTS -----
	
	@PostMapping("new-customer")
	public String addCustomer(Model model,
	                          @RequestParam String name,
	                          @RequestParam String surname,
	                          @RequestParam Integer age)
	{
		if (isAccessingIllegally()) return "redirect:/auth";
		
		logger.info("New Customer :: (name = {}, surname = {}, age = {})", name, surname, age);
		
		customerService.saveCustomer(new Customer(name, surname, age, new HashSet<>()));
		return "redirect:/";
	}
	
	@PostMapping("edit-customer/{customerId}")
	public String editCustomer(@PathVariable Integer customerId,
	                           @RequestParam String name,
	                           @RequestParam String surname,
	                           @RequestParam Integer age)
	{
		if (isAccessingIllegally()) return "redirect:/auth";
		
		logger.info("Customer Edit :: (name = {}, surname = {}, age = {})", name, surname, age);
		
		CustomerBean customerBean = customerService.getCustomerById(customerId);
		Customer existingCustomer = new Customer(name, surname, age, customerBean.getCars());
		existingCustomer.setId(customerBean.getId());
		
		customerService.saveCustomer(existingCustomer);
		return "redirect:/";
	}
	
	@PostMapping("del-customer/{customerId}")
	public String deleteCustomer(Model model, @PathVariable Integer customerId)
	{
		if (isAccessingIllegally()) return "redirect:/auth";
		
		logger.info("Customer Deletion :: (id = {})", customerId);
		
		model = getUpdatedModel(model);
		
		customerService.removeCustomerById(customerId);
		return "redirect:/";
	}
	
	@PostMapping("new-car")
	public String addCar(@RequestParam String make,
	                     @RequestParam String model,
	                     @RequestParam Integer year)
	{
		if (isAccessingIllegally()) return "redirect:/auth";
		
		logger.info("New Car :: (make = {}, model = {}, year = {})", make, model, year);
		
		carService.saveCar(new Car(make, model, year));
		return "redirect:/";
	}
	
	@PostMapping("edit-car/{carId}")
	public String editCar(@PathVariable Integer carId,
	                      @RequestParam String make,
	                      @RequestParam String model,
	                      @RequestParam Integer year)
	{
		if (isAccessingIllegally()) return "redirect:/auth";
		
		logger.info("Car Edit :: (make = {}, model = {}, year = {})", make, model, year);
		
		CarBean carBean = carService.getCarById(carId);
		Car existingCar = new Car(make, model, year);
		existingCar.setId(carBean.getId());
		
		carService.saveCar(existingCar);
		return "redirect:/";
	}
	
	@PostMapping("del-car/{carId}")
	public String deleteCar(Model model, @PathVariable Integer carId)
	{
		if (isAccessingIllegally()) return "redirect:/auth";
		
		logger.info("Car Deletion :: (id = {})", carId);
		
		model = getUpdatedModel(model);
		
		carService.removeCarById(carId);
		return "redirect:/";
	}
	
	@PostMapping("rent/{customerId}/{carId}")
	public String rent(Model model,
	                   @PathVariable Integer customerId,
	                   @PathVariable Integer carId)
	{
		if (isAccessingIllegally()) return "redirect:/auth";
		
		logger.info("Car Rent :: (carId = {}, customerId = {})", carId, customerId);
		
		customerService.rentCar(customerId, carId);
		
		return "redirect:/";
	}
	
	@PostMapping("unrent/{customerId}/{carId}")
	public String unrent(Model model,
	                     @PathVariable Integer customerId,
	                     @PathVariable Integer carId)
	{
		if (isAccessingIllegally()) return "redirect:/auth";
		
		logger.info("Car Unrent :: (carId = {}, customerId = {})", carId, customerId);
		
		customerService.unrentCar(customerId, carId);
		
		return "redirect:/";
	}
	
	public Model getUpdatedModel(Model model)
	{
		model.addAttribute("customers", customerService.getCustomerList());
		model.addAttribute("cars", carService.getCarList());
		model.addAttribute("user", authService.getLoggedInUser());
		return model;
	}
	
	private boolean isAccessingIllegally()
	{
		if (!authService.isUserLoggedIn())
		{
			logger.warn("Illegal Access :: The user attempted to access a restricted page without logging in. Redirecting...");
			return true;
		}
		
		return false;
	}
}
