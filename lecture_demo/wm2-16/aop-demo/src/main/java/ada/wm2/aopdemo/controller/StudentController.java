package ada.wm2.aopdemo.controller;

import ada.wm2.aopdemo.dto.StudentDto;
import ada.wm2.aopdemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/all")
    public List<StudentDto> getStudentList() {
        return studentService.getStudentList();
    }
}
