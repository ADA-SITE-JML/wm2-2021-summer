package ada.wm2.carrental.service;

import ada.wm2.carrental.bean.CustomerBean;
import ada.wm2.carrental.entity.Car;
import ada.wm2.carrental.entity.Customer;
import ada.wm2.carrental.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerService
{
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	CarService carService;
	
	public CustomerBean getCustomerById(Integer id)
	{
		Customer customer = customerRepository.findById(id).orElse(null);
		
		if (customer != null)
		{
			customer.setCars(getCarsForCustomer(customer));
			return new CustomerBean(customer);
		}
		else return null;
	}
	
	public List<CustomerBean> getCustomerList()
	{
		List<Customer> customers;
		List<CustomerBean> customerBeans = new ArrayList<>();
		
		customers = (List<Customer>) customerRepository.findAll();
		
		for (Customer customer : customers)
		{
			customer.setCars(getCarsForCustomer(customer));
			customerBeans.add(new CustomerBean(customer));
		}
		
		return customerBeans;
	}
	
	public void saveCustomer(Customer customer)
	{
		customerRepository.save(customer);
	}
	
	public void removeCustomerById(Integer id)
	{
		List<Integer> rentedCarIds = customerRepository.getCarsRentedBy(id);
		for(Integer carId : rentedCarIds) // removing renter of each car
		{
			Car car = new Car(carService.getCarById(carId));
			car.setRenter(null);
			carService.saveCar(car);
		}
		
		customerRepository.deleteCarsOfCustomer(id); // prevents foreign key problems
		customerRepository.deleteById(id);
	}
	
	public void rentCar(Integer customerId, Integer carId)
	{
		Customer customer = new Customer(getCustomerById(customerId));
		customer.setCars(getCarsForCustomer(customer));
		
		Car car = new Car(carService.getCarById(carId));
		car.setRenter(customer);
		customer.getCars().add(car);
		
		carService.saveCar(car);
		customerRepository.save(customer);
	}
	
	public void unrentCar(Integer customerId, Integer carId)
	{
		Customer customer = new Customer(getCustomerById(customerId));
		customer.setCars(getCarsForCustomer(customer));
		
		Car car = new Car(carService.getCarById(carId));
		customer.getCars().remove(car);
		car.setRenter(null);
		
		carService.saveCar(car);
		customerRepository.save(customer);
		customerRepository.deleteRent(customerId, carId);
	}
	
	private Set<Car> getCarsForCustomer(Customer customer)
	{
		Set<Car> rentedCars = new HashSet<>();
		
		List<Integer> rentedCarIds = customerRepository.getCarsRentedBy(customer.getId());
		for(Integer carId : rentedCarIds)
		{
			rentedCars.add(new Car(carService.getCarById(carId)));
		}
		
		return rentedCars;
	}
}
