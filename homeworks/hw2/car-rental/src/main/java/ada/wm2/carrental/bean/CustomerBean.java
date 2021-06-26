package ada.wm2.carrental.bean;

import ada.wm2.carrental.entity.Car;
import ada.wm2.carrental.entity.Customer;

import java.util.HashSet;
import java.util.Set;

public class CustomerBean
{
	private String name;
	private String surname;
	private int age;
	private Integer id;
	private Set<Car> cars;
	
	public CustomerBean(String name, String surname, int age, Integer id)
	{
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.id = id;
		this.cars = new HashSet<>();
	}
	
	public CustomerBean(Customer customer)
	{
		this.name = customer.getName();
		this.surname = customer.getSurname();
		this.age = customer.getAge();
		this.id = customer.getId();
		this.cars = customer.getCars();
	}
	
	public Integer getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getSurname()
	{
		return surname;
	}
	
	public void setSurname(String surname)
	{
		this.surname = surname;
	}
	
	public int getAge()
	{
		return age;
	}
	
	public void setAge(int age)
	{
		this.age = age;
	}
	
	public Set<Car> getCars()
	{
		return cars;
	}
	
	public void setCars(Set<Car> cars)
	{
		this.cars = cars;
	}
}
