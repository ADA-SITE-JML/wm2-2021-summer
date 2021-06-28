package ada.wm2.mongodemo.service;

import ada.wm2.mongodemo.dto.StudentDTO;
import ada.wm2.mongodemo.entity.Student;
import ada.wm2.mongodemo.mapper.StudentMapper;
import ada.wm2.mongodemo.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public StudentDTO getStudent(String id) {
        Optional<Student> studentOp = studentRepository.findById(id);
        if (studentOp.isPresent()) {
            Student std =  studentOp.get();
            StudentDTO stdDTO = StudentMapper.INSTANCE.studentToDTO(std);
            return stdDTO;
        }
        else
            return new StudentDTO();
    }

    public List<StudentDTO> getStudentByGPA(double a, double b) {
        List<Student> students = studentRepository.findStudentsByGpaBetween(a,b);
        List<StudentDTO> studentDTOs = StudentMapper.INSTANCE.studentListToDTO(students);
        return studentDTOs;
    }
}
