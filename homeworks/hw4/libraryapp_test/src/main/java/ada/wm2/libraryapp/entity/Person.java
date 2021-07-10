package ada.wm2.libraryapp.entity;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Size(min = 2,message = "Name cannot be less than 2 characters")
    @Column(name = "NAME")
    private String name;

    @Size(min = 2,message = "Name cannot be less than 5 characters")
    @Column(name = "SURNAME")
    private String surname;

    @Positive(message = "Age cannot be minus")
    @Max(value = 200,message = "Age should not be bigger than 200")
    @NotNull(message = "Person's age cannot be null.")
    @Column(name = "AGE")
    private Short age;


    @Column(name = "GENDER")
    private Character gender;

    @OneToMany(mappedBy = "person")
    private List<Book> books;





    public static Person edit(Person person, Person person2) {
        person.setId(person2.getId());
        person.setName(person2.getName());
        person.setAge(person2.getAge());
        person.setSurname(person2.getSurname());
        person.setGender(person2.getGender());
        return person;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

}
