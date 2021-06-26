package ada.wm2.sbhw.bean;

public class EmployeeBean {
    private String name;
    private String position;
    private String hours;

    public EmployeeBean(String name, String position, String hours) {
        this.name = name;
        this.position = position;
        this.hours = hours;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }
}