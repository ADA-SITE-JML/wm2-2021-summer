package ada.wm2.bookauthor.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "Books")
public class BookEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="B_ID")
	private Integer id;

	@Column(name="BOOK_NAME")
	@NotBlank(message = "Example: War and Peace")
	@Size(min=2,max = 40)
	private String name;

	@Column(name="PUB_DATE")
	@NotBlank(message = "Example: 10.12.2001")
	@Size(min=2,max = 10)
	private String pubDate;

	@ManyToMany(mappedBy = "books")
	Set<AuthorEntity> authors;
	
	public BookEntity(Integer id, String name, String pubDate)
	{
		this.id = id;
		this.name = name;
		this.pubDate = pubDate;
	}
	
	public BookEntity(String name, String pubDate)
	{
		this.name = name;
		this.pubDate = pubDate;
	}
	
	public BookEntity() {}
	
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

	public Set<AuthorEntity> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<AuthorEntity> authors) {
		this.authors = authors;
	}
}
