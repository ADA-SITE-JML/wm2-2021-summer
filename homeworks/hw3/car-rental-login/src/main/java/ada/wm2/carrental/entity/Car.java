package ada.wm2.carrental.entity;

import ada.wm2.carrental.bean.CarBean;

import javax.persistence.*;

@Entity
@Table(name = "CARS")
public class Car
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CAR_ID")
	private Integer id;
	
	private String make;
	
	private String model;
	
	private int year;
	
	@ManyToOne
	private Customer renter;
	
	public Car(String make, String model, int year)
	{
		this.make = make;
		this.model = model;
		this.year = year;
	}
	
	public Car(CarBean carBean)
	{
		this.make = carBean.getMake();
		this.model = carBean.getModel();
		this.year = carBean.getYear();
		this.id = carBean.getId();
	}
	
	public Car()
	{
	}
	
	public Integer getId()
	{
		return id;
	}
	
	public void setId(Integer id)
	{
		this.id = id;
	}
	
	public String getMake()
	{
		return make;
	}
	
	public void setMake(String make)
	{
		this.make = make;
	}
	
	public String getModel()
	{
		return model;
	}
	
	public void setModel(String model)
	{
		this.model = model;
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
	
	@Override
	public String toString()
	{
		return "(#" + getId() + ", " + getMake() + ", " + getModel() + ", " + getYear() + ")";
	}
}
