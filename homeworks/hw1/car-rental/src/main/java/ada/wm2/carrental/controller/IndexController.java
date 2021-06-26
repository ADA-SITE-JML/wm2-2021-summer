package ada.wm2.carrental.controller;

import ada.wm2.carrental.bean.CarBean;
import ada.wm2.carrental.bean.CustomerBean;
import ada.wm2.carrental.entity.Car;
import ada.wm2.carrental.entity.Customer;
import ada.wm2.carrental.service.CarService;
import ada.wm2.carrental.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;

@Controller
public class IndexController
{
	@Autowired
	CustomerService customerService;
	
	@Autowired
	CarService carService;
	
	
	// ----- GET REQUESTS -----
	
	@GetMapping
	public String getIndexPage(Model model)
	{
		model = getUpdatedModel(model);
		
		return "welcome";
	}
	
	@GetMapping("new-customer")
	public String getCustomerAddPage(Model model)
	{
		model.addAttribute("add", true);
		return "customerAddEdit";
	}
	
	@GetMapping("edit-customer/{customerId}")
	public String getCustomerEditPage(Model model, @PathVariable Integer customerId)
	{
		CustomerBean customerBean = customerService.getCustomerById(customerId);
		model.addAttribute("add", false);
		model.addAttribute("customer", customerBean);
		return "customerAddEdit";
	}
	
	@GetMapping("new-car")
	public String getCarAddPage(Model model)
	{
		model.addAttribute("add", true);
		return "carAddEdit";
	}
	
	@GetMapping("edit-car/{carId}")
	public String getCarEditPage(Model model, @PathVariable Integer carId)
	{
		CarBean carBean = carService.getCarById(carId);
		model.addAttribute("add", false);
		model.addAttribute("car", carBean);
		return "carAddEdit";
	}
	
	@GetMapping("rent/{customerId}")
	public String getRentPage(Model model, @PathVariable Integer customerId)
	{
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
		System.out.println("New customer (" + name + ", " + surname + ", " + age + ")");
		customerService.saveCustomer(new Customer(name, surname, age, new HashSet<>()));
		return "redirect:/";
	}
	
	@PostMapping("edit-customer/{customerId}")
	public String editCustomer(@PathVariable Integer customerId,
	                           @RequestParam String name,
	                           @RequestParam String surname,
	                           @RequestParam Integer age)
	{
		System.out.println("Edited customer (" + name + ", " + surname + ", " + age + ")");
		
		CustomerBean customerBean = customerService.getCustomerById(customerId);
		Customer existingCustomer = new Customer(name, surname, age, customerBean.getCars());
		existingCustomer.setId(customerBean.getId());
		
		customerService.saveCustomer(existingCustomer);
		return "redirect:/";
	}
	
	@PostMapping("del-customer/{customerId}")
	public String deleteCustomer(Model model, @PathVariable Integer customerId)
	{
		System.out.println("Deleting customer with id :" + customerId);
		
		model = getUpdatedModel(model);
		
		customerService.removeCustomerById(customerId);
		return "redirect:/";
	}
	
	@PostMapping("new-car")
	public String addCar(@RequestParam String make,
	                     @RequestParam String model,
	                     @RequestParam Integer year)
	{
		System.out.println("New car (" + make + ", " + model + ", " + year + ")");
		carService.saveCar(new Car(make, model, year));
		return "redirect:/";
	}
	
	@PostMapping("edit-car/{carId}")
	public String editCar(@PathVariable Integer carId,
	                      @RequestParam String make,
	                      @RequestParam String model,
	                      @RequestParam Integer year)
	{
		System.out.println("Edited car (" + make + ", " + model + ", " + year + ")");
		
		CarBean carBean = carService.getCarById(carId);
		Car existingCar = new Car(make, model, year);
		existingCar.setId(carBean.getId());
		
		carService.saveCar(existingCar);
		return "redirect:/";
	}
	
	@PostMapping("del-car/{carId}")
	public String deleteCar(Model model, @PathVariable Integer carId)
	{
		System.out.println("Deleting car with id :" + carId);
		
		model = getUpdatedModel(model);
		
		carService.removeCarById(carId);
		return "redirect:/";
	}
	
	@PostMapping("rent/{customerId}/{carId}")
	public String rent(Model model,
	                   @PathVariable Integer customerId,
	                   @PathVariable Integer carId)
	{
		System.out.println("Renting car with id: " + carId + " for customer with id: " + customerId);
		
		customerService.rentCar(customerId, carId);
		
		return "redirect:/";
	}
	
	@PostMapping("unrent/{customerId}/{carId}")
	public String unrent(Model model,
	                   @PathVariable Integer customerId,
	                   @PathVariable Integer carId)
	{
		System.out.println("Unrenting car with id: " + carId + " for customer with id: " + customerId);
		
		customerService.unrentCar(customerId, carId);
		
		return "redirect:/";
	}
	
	public Model getUpdatedModel(Model model)
	{
		model.addAttribute("customers", customerService.getCustomerList());
		model.addAttribute("cars", carService.getCarList());
		return model;
	}
}
