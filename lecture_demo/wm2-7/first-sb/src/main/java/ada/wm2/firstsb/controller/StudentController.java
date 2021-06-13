package ada.wm2.firstsb.controller;

import ada.wm2.firstsb.bean.StudentBean;
import ada.wm2.firstsb.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/list")
    public String getStudentList(Model model) {
        List<StudentBean> studentList = studentService.getStudentList();

        model.addAttribute("students",studentList);
        return "student_list";
    }
}
