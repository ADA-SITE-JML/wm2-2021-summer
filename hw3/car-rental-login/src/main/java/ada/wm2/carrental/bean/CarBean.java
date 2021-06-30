package ada.wm2.carrental.bean;

import ada.wm2.carrental.entity.Car;
import ada.wm2.carrental.entity.Customer;

public class CarBean
{
	private String model;
	private String make;
	private int year;
	private Integer id;
	private Customer renter;
	
	public CarBean(String model, String make, int year, Integer id)
	{
		this.model = model;
		this.make = make;
		this.year = year;
		this.id = id;
	}
	
	public CarBean(Car car)
	{
		this.model = car.getModel();
		this.make = car.getMake();
		this.year = car.getYear();
		this.id = car.getId();
		this.renter = car.getRenter();
	}
	
	public Integer getId()
	{
		return id;
	}
	
	public void setId(Integer id)
	{
		this.id = id;
	}
	
	public String getModel()
	{
		return model;
	}
	
	public void setModel(String model)
	{
		this.model = model;
	}
	
	public String getMake()
	{
		return make;
	}
	
	public void setMake(String make)
	{
		this.make = make;
	}
	
	public int getYear()
	{
		return year;
	}
	
	public void setYear(int year)
	{
		this.year = year;
	}
	
	public Customer getRenter()
	{
		return renter;
	}
	
	public void setRenter(Customer renter)
	{
		this.renter = renter;
	}
}
