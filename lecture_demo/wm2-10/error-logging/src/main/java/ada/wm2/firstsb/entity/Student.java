package ada.wm2.firstsb.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name="STUDENTS")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ST_ID")
    private Integer id;

    @Column(name="FNAME")
    @NotBlank(message = "Bele de ad olar?")
    @Size(min=2,max = 20)
    private String firstName;

    @Column(name="LNAME")
    @NotBlank
    @Size(min=2,max = 20)
    private String lastName;

    @Column(name="EMAIL")
    @Email
    private String email;

    @Column(name="SCHOOL")
    @NotBlank(message = "SITE, SPIA or SB please")
    private String school;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "ENROLLMENTS",
            joinColumns = @JoinColumn(name = "ST_ID"),
            inverseJoinColumns = @JoinColumn(name = "COURSE_ID"))
    private Set<Course> courses;

    public Student() {
    }

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
