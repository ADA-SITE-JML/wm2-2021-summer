package ada.wm2;

public class StudentBean implements java.io.Serializable {
	private String firstName;
	private String lastName;
	private String major;

	public void setFirstName(String fn) {
		firstName = fn;
	}

	public void setLastName(String ln) {
		lastName = ln;
	}
	public void setMajor(String mj) {
		major = mj;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getMajor() {
		return major;
	}
}
