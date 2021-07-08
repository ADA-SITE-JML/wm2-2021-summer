package ada.wm2.tst.controller;

import ada.wm2.tst.entity.Student;
import ada.wm2.tst.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/list")
    public String getStudentList(Model model) {
        List<Student> studentList = studentService.getStudentList();

        model.addAttribute("students",studentList);
        return "student_list";
    }

    @GetMapping("/new")
    public String showEditForm(Model model) {
        model.addAttribute("student", new Student());
        return "student_form";
    }

    @PostMapping("/save")
    public String showEditForm(Model model,Student std) {
        Student updStd = studentService.saveStudent(std);

        model.addAttribute("student",updStd);
        return "redirect:/student/list";
    }

}
