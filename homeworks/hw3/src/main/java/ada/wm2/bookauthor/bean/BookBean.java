package ada.wm2.bookauthor.bean;

import ada.wm2.bookauthor.entity.BookEntity;

public class BookBean
{
	private Integer id;
	private String name;
	private String pubDate;
	
	public BookBean(Integer id, String name, String pubDate)
	{
		this.id = id;
		this.name = name;
		this.pubDate = pubDate;
	}
	
	public BookBean()
	{}
	
	public BookBean(BookEntity bookEntity)
	{
		this.id = bookEntity.getId();
		this.name = bookEntity.getName();
		this.pubDate = bookEntity.getPubDate();
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
	
	public String getPubDate()
	{
		return pubDate;
	}
	
	public void setPubDate(String pubDate)
	{
		this.pubDate = pubDate;
	}
}
