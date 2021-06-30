package ada.wm2.mongodemo.init;

import ada.wm2.mongodemo.entity.Course;
import ada.wm2.mongodemo.entity.Student;
import ada.wm2.mongodemo.repo.CourseRepository;
import ada.wm2.mongodemo.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataBootstrap implements CommandLineRunner {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CourseRepository courseRepository;

    @Override
    public void run(String... args) throws Exception {
        // Remove the existing data
        courseRepository.deleteAll();
        studentRepository.deleteAll();

        // Add new data
        Course c1 = new Course("1","Web & Mobile 1");
        courseRepository.save(c1);
        Course c2 = new Course("2","Web & Mobile 2");
        courseRepository.save(c2);
        Course c3 = new Course("3","Programming Principles I");
        courseRepository.save(c3);

        List<Course> courses = new ArrayList<>();
        courses.add(c1);

        Student std = new Student("1", "Jamal", "Hasanov", 2.2, "abc123",courses);
        studentRepository.save(std);

        courses.add(c2);
        std = new Student("2", "Fagan", "Rasulov", 3.2, "123456",courses);
        studentRepository.save(std);

        courses.add(c3);
        std = new Student("3", "Shamil", "Salayev", 1.9, "xx893",courses);
        studentRepository.save(std);
        std = new Student("4", "Xuraman", "Huseynova", 3.5, "ssssss222",courses);
        studentRepository.save(std);
        std = new Student("5", "Shahla", "Abdinova", 2.5, "123456",courses);
        studentRepository.save(std);
        std = new Student("6", "Sinay", "Suleymanova", 3.4, "dsdsd",courses);
        studentRepository.save(std);
    }
}
 
