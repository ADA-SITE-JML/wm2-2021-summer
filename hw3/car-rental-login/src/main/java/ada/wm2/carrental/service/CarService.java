package ada.wm2.carrental.service;

import ada.wm2.carrental.bean.CarBean;
import ada.wm2.carrental.bean.CustomerBean;
import ada.wm2.carrental.entity.Car;
import ada.wm2.carrental.entity.Customer;
import ada.wm2.carrental.repo.CarRepository;
import ada.wm2.carrental.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService
{
	@Autowired
	CarRepository carRepository;
	
	public CarBean getCarById(Integer id)
	{
		Car car = carRepository.findById(id).orElse(null);
		
		if (car != null)
			return new CarBean(car);
		else return null;
	}
	
	public List<CarBean> getCarList()
	{
		List<Car> cars;
		List<CarBean> carBeans = new ArrayList<>();
		
		cars = (List<Car>) carRepository.findAll();
		
		for(Car car: cars)
		{
			carBeans.add(new CarBean(car));
		}
		
		return carBeans;
	}
	
	public void saveCar(Car car)
	{
		carRepository.save(car);
	}
	
	public void removeCarById(Integer id)
	{
		carRepository.deleteCarRenter(id); // prevents foreign key problems
		carRepository.deleteById(id);
	}
}
