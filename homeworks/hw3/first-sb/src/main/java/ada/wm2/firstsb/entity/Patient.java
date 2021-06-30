package ada.wm2.firstsb.entity;


import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name="PATIENTS")
public class Patient {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="PATIENT_ID")

    private Integer id;
    @Column(name="FNAME")
    @NotBlank(message = "first name cannot remain blank")
    private String firstName;


    @Column(name="LNAME")
    @NotBlank(message = "last name cannot remain blank")
    private String lastName;


    @Column(name="PROBLEM")
    @NotBlank(message = "specify your problem")

    private String problem;



    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "ENROLLMENTS",
            joinColumns = @JoinColumn(name = "PATIENT_ID"),
            inverseJoinColumns = @JoinColumn(name = "DOCTOR_ID"))
    private Set<Doctor> doctors;

    public Patient() {
    }

    public Patient(String firstName) {
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

    public Set<Doctor> getCourses() {
        return doctors;
    }

    public void setCourses(Set<Doctor> doctors) {
        this.doctors = doctors;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }
}
