package ada.wm2.rest.controller;

import ada.wm2.rest.dto.StudentDTO;
import ada.wm2.rest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/{id}")
    public StudentDTO getStudent(@PathVariable Integer id) {
        return studentService.getStudent(id);
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<StudentDTO> getStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public StudentDTO saveStudent(@RequestBody StudentDTO studentDTO) {
        return studentService.saveStudent(studentDTO);
    }
}
