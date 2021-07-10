package ada.wm2.libraryapp.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Book {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @NotEmpty(message = "Book's name cannot be empty.")
    @Size(min = 2,message = "Name cannot be less than 2 characters")
    @Column(name = "BOOKNAME")
    private String name;


    @NotEmpty(message = "Book's desciption cannot be empty.")
    @Size(min = 5,message = "Description should not be shorter than 5 characters")
    @Column(name = "GENRES")
    private String description;

    @NotEmpty(message = "Book's author cannot be empty.")
    @Size(min = 2,message = "Name cannot be less than 2 characters")
    @Column(name = "AUTHOR")
    private String author;


    @ManyToOne
    @JoinColumn(name = "PERSON_ID", referencedColumnName = "ID")
    private Person person;



   //  ?????????????????
    public static Book editBook(Book book, Book book2) {
        book.setAuthor(book2.getAuthor());
        book.setDescription(book2.getDescription());
        book.setName(book2.getName());
        return book;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
