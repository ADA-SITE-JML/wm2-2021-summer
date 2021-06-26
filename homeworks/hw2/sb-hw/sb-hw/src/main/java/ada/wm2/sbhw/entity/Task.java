package ada.wm2.sbhw.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="TASKS")

public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "T_ID")
    Integer id;

    @Column(name = "T_NAME")
    String taskName;

    @Column(name = "DURATION")
    Integer duration;

    @ManyToMany(mappedBy = "tasks")
    private Set<Employee> employees;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}