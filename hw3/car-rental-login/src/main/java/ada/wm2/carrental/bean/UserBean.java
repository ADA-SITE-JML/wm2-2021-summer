package ada.wm2.carrental.bean;

import ada.wm2.carrental.entity.User;

public class UserBean
{
	private Integer id;
	private String email;
	private String name;
	
	public UserBean(Integer id, String email, String name)
	{
		this.id = id;
		this.email = email;
		this.name = name;
	}
	public UserBean(User user)
	{
		this.id = user.getId();
		this.email = user.getEmail();
		this.name = user.getName();
	}
	
	public Integer getId()
	{
		return id;
	}
	
	public void setId(Integer id)
	{
		this.id = id;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
}
