package ada.wm2.sbhw.entity;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="EMPLOYEES")

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="EMP_ID")
    private Integer id;

    @Column(name="EMP_NAME")
    private String name;

    @Column(name="POSITION")
    private String position;

    @Column(name="HOURS")
    private String hours;

    @ManyToMany
    @JoinTable(name = "ASSIGNED",
            joinColumns = @JoinColumn(name = "EMP_ID"),
            inverseJoinColumns = @JoinColumn(name = "T_ID"))
    private Set<Task> tasks;


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

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }
}
