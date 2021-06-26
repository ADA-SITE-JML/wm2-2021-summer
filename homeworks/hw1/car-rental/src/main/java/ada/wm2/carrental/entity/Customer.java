package ada.wm2.carrental.entity;

import ada.wm2.carrental.bean.CustomerBean;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "CUSTOMERS")
public class Customer
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CUST_ID")
	private Integer id;
	
	private String name;
	
	private String surname;
	
	private Integer age;
	
	@OneToMany
	@JoinTable(name = "rents",
			joinColumns = @JoinColumn(name = "CUST_ID"),
			inverseJoinColumns = @JoinColumn(name = "CAR_ID"))
	private Set<Car> cars;
	
	public Customer(String name, String surname, Integer age, Set<Car> cars)
	{
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.cars = cars;
	}
	
	public Customer(CustomerBean customerBean)
	{
		this.name = customerBean.getName();
		this.surname = customerBean.getSurname();
		this.age = customerBean.getAge();
		this.id = customerBean.getId();
		this.cars = customerBean.getCars();
	}
	
	public Customer()
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
	
	public Integer getAge()
	{
		return age;
	}
	
	public void setAge(Integer age)
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
	
	@Override
	public String toString()
	{
		return "(#" + getId() + ", " + getName() + ", " + getSurname() + ")";
	}
}
