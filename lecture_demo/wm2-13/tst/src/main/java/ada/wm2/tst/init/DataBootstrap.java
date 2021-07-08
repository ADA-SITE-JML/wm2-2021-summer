package ada.wm2.tst.init;

import ada.wm2.tst.entity.Student;
import ada.wm2.tst.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataBootstrap implements CommandLineRunner {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {
        Student st = new Student("Elvina", "Ismayilova");
        studentRepository.save(st);
        st = new Student("Ismayil", "Karimli");
        studentRepository.save(st);
        st = new Student("Khanim", "Huseynzade");
        studentRepository.save(st);
    }
}
