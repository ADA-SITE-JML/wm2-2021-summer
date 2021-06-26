package ada.wm2.firstsb.entity;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="PATIENTS")
public class Patient {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="PATIENT_ID")
    private Integer id;
    @Column(name="FNAME")

    private String firstName;


    @Column(name="LNAME")
    private String lastName;


    @Column(name="PROBLEM")
    private String problem;



    @ManyToMany
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
