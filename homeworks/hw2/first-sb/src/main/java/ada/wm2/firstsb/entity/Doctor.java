package ada.wm2.firstsb.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="DOCTORS")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="DOCTOR_ID")
    private Integer id;

    @Column(name="DOCTOR_NAME")
    private String doctorName;

    @ManyToMany(mappedBy = "doctors")

   private Set<Patient> patients;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public Set<Patient> getPatients() {
        return patients;
    }

    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
    }
}
