package ada.wm2.firstsb.service;

import ada.wm2.firstsb.bean.StudentBean;
import ada.wm2.firstsb.entity.Student;
import ada.wm2.firstsb.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<Student> getAllGirls() {
        List<Student> studentList = (List<Student>) studentRepository.findAllGirls();

        return studentList;
    }

    public  Student getByNameAndSurname(String first, String last) {
        Optional<Student> std = studentRepository.findByFirstNameAndLastName(first,last);
        if (std.isPresent())
            return std.get();
        else
            return new Student("Nobody","Found");
    }

    public List<Student> getByNameOrSurname(String first, String last) {
        List<Student> studentList = (List<Student>) studentRepository.findByFirstNameOrLastName(first,last);

        return studentList;
    }

    public Student getStudent(Integer studentId) {
        Optional<Student> std = studentRepository.findById(studentId);
        if (std.isPresent())
            return std.get();
        else
            return new Student("Noname","Nonameli");
    }

    public List<Student> getStudentList() {
        List<Student> studentList = (List<Student>) studentRepository.findAll();

        return studentList;
    }

    public Student saveStudent(Student std) {
        Student savedStd = studentRepository.save(std);
        return savedStd;
    }
}
