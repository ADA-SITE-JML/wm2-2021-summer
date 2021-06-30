package ada.wm2.firstsb.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="COURSES")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="COURSE_ID")
    private Integer id;

    @Column(name="COURSE_NAME")
    private String courseName;

    @ManyToMany(mappedBy = "courses")
    private Set<Student> students;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
