package ada.wm2.mongodemo.controller;

import ada.wm2.mongodemo.dto.StudentDTO;
import ada.wm2.mongodemo.entity.Student;
import ada.wm2.mongodemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/{id}")
    public StudentDTO getStudent(@PathVariable String id) {
        StudentDTO studentDTO = studentService.getStudent(id);
        return studentDTO;
    }

    @PostMapping("/{a}/{b}")
    public List<StudentDTO> getByGpaRange(@PathVariable Double a, @PathVariable Double b) {
        List<StudentDTO> students = studentService.getStudentByGPA(a,b);
        return students;
    }
}
