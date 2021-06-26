package ada.wm2.bookauthor.bean;

import ada.wm2.bookauthor.entity.AuthorEntity;
import ada.wm2.bookauthor.entity.BookEntity;

import java.util.HashSet;
import java.util.Set;

public class AuthorBean
{
	private Integer id;
	private String name;
	private String birthDate;
	private Set<BookEntity> books = new HashSet<>();
	
	
	public AuthorBean(Integer id, String name, String birthDate)
	{
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}
	
	public AuthorBean(AuthorEntity authorEntity)
	{
		this.id = authorEntity.getId();
		this.name = authorEntity.getName();
		this.birthDate = authorEntity.getBirthDate();
		this.books = authorEntity.getBooks();
	}
	
	public boolean hasBookWithID(Integer bookID)
	{
		for (BookEntity bookEntity : books)
		{
			if(bookEntity.getId().equals(bookID))
			{
				return true;
			}
		}
		return false;
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
	
	public String getBirthDate()
	{
		return birthDate;
	}
	
	public void setBirthDate(String birthDate)
	{
		this.birthDate = birthDate;
	}
	
	public Set<BookEntity> getBooks()
	{
		return books;
	}
	
	public void setBooks(Set<BookEntity> books)
	{
		this.books = books;
	}
}
