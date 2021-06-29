package ada.wm2.rest.service;

import ada.wm2.rest.dto.StudentDTO;
import ada.wm2.rest.entity.Student;
import ada.wm2.rest.mapper.StudentMapper;
import ada.wm2.rest.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public StudentDTO getStudent(Integer studentId) {
        Optional<Student> studentOp = studentRepository.findById(studentId);
        if (studentOp.isPresent()) {
            Student student = studentOp.get();
            return StudentMapper.INSTANCE.studentToDTO(student);
        }
        else
            return new StudentDTO();
    }

    public StudentDTO saveStudent(StudentDTO studentDTO) {
        Student student = StudentMapper.INSTANCE.StudentDTOToEntity(studentDTO);
        Student savedStudent = studentRepository.save(student);
        return StudentMapper.INSTANCE.studentToDTO(savedStudent);
    }

    public List<StudentDTO> getAllStudents() {
        Iterable<Student> studentList = studentRepository.findAll();
        return StudentMapper.INSTANCE.studentListToDTO(studentList);
    }
}
