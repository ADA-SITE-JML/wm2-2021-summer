package ada.wm2.bookauthor.entity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Set;

@Entity
@Table(name = "Authors")

public class AuthorEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="A_ID")
	private Integer id;

	@Column(name="AUTHOR_NAME")
	@NotBlank(message = "Example: Elnur or Elnur Abdullayev")
	@Size(min=2,max = 20)
	private String name;

	@Column(name="BIRTH_DATE")
	@NotBlank(message = "Example: 01.01.2021")
	@Size(min=2,max = 10)
	private String birthDate;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "PUBLISHMENT",
			joinColumns = @JoinColumn(name = "A_ID"),
			inverseJoinColumns = @JoinColumn(name = "B_ID"))
	private Set<BookEntity> books;
	
	public AuthorEntity(Integer id, String name, String birthDate)
	{
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}
	
	public AuthorEntity(String name, String birthDate)
	{
		this.name = name;
		this.birthDate = birthDate;
	}
	
	public AuthorEntity()
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
	
	public String getBirthDate()
	{
		return birthDate;
	}
	
	public void setBirthDate(String birthDate)
	{
		this.birthDate = birthDate;
	}

	public Set<BookEntity> getBooks() {
		return books;
	}

	public void setBooks(Set<BookEntity> books) {
		this.books = books;
	}
	
}
