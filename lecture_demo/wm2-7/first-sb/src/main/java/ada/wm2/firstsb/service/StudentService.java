package ada.wm2.firstsb.service;

import ada.wm2.firstsb.bean.StudentBean;
import ada.wm2.firstsb.entity.Student;
import ada.wm2.firstsb.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<Student> getStudentList() {
        List<Student> studentList = (List<Student>) studentRepository.findAll();

        return studentList;
    }
}
