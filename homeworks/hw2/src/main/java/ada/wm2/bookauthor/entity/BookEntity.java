package ada.wm2.bookauthor.entity;

import javax.persistence.*;
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
	private String name;

	@Column(name="PUB_DATE")
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
