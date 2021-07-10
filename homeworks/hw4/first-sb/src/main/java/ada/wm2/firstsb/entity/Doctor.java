package ada.wm2.firstsb.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name="DOCTORS")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="DOCTOR_ID")

    private Integer id;

    @Column(name="F_NAME")
    @NotBlank(message = "last name cannot remain blank")
    private String firstName;

    @Column(name="L_NAME")
    @NotBlank(message = "last name cannot remain blank")
    private String lastName;


    @Column(name="SHIFT")
    @NotBlank(message = "specify doctor shift (morning/night)")
    private String shift;

    @ManyToMany(mappedBy = "doctors")

    private Set<Patient> patients;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String doctorName) {
        this.firstName = doctorName;
    }

    public Set<Patient> getPatients() {
        return patients;
    }

    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }
}
