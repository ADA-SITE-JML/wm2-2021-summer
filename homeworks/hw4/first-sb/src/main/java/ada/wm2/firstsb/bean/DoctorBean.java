package ada.wm2.firstsb.bean;

import ada.wm2.firstsb.entity.Doctor;

public class DoctorBean {

    private String firstName;
    private String lastName;

    public DoctorBean(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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
}
