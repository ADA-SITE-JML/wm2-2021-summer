package ada.wm2.tst.service;

import ada.wm2.tst.entity.Student;
import ada.wm2.tst.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public Student getStudent(Integer studentId) {
        Optional<Student> studentOp = studentRepository.findById(studentId);
        if (studentOp.isPresent())
            return studentOp.get();
        else
            return new Student();
    }

    public List<Student> getStudentList() {
        return (List<Student>)studentRepository.findAll();
    }

    public Student saveStudent(Student std) {
        return studentRepository.save(std);
    }
}
