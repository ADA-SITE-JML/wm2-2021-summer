package ada.wm2.firstsb.bean;

import ada.wm2.firstsb.entity.Patient;

public class PatientBean {

    private String firstName;
    private String lastName;

    public PatientBean(String firstName, String lastName) {
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
