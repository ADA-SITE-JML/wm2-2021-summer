package ada.wm2.firstsb.controller;

import ada.wm2.firstsb.bean.StudentBean;
import ada.wm2.firstsb.entity.Student;
import ada.wm2.firstsb.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/new")
    public String showEditForm(Model model) {
        model.addAttribute("student",new Student());
        return "student_form";
    }

    @GetMapping("/edit/{studentId}")
    public String showEditForm(Model model,@PathVariable Integer studentId) {
        Student std = studentService.getStudent(studentId);

        model.addAttribute("student",std);
        return "student_form";
    }

    @PostMapping("/save")
    public String showEditForm(Model model,Student std) {
        Student updStd = studentService.saveStudent(std);

        model.addAttribute("student",updStd);
        return "student_data";
    }


    @GetMapping("/girls")
    public String getStudentByNameOr(Model model) {
        List<Student> studentList = studentService.getAllGirls();

        model.addAttribute("students",studentList);
        return "student_list";
    }

    @GetMapping("/and/{firstName}/{lastName}")
    public String getStudentByName(Model model, @PathVariable String firstName, @PathVariable String lastName) {
        Student std = studentService.getByNameAndSurname(firstName,lastName);
        model.addAttribute("student",std);
        return "student_data";
    }

    @GetMapping("/or/{firstName}/{lastName}")
    public String getStudentByNameOr(Model model, @PathVariable String firstName, @PathVariable String lastName) {
        List<Student> studentList = studentService.getByNameOrSurname(firstName,lastName);

        model.addAttribute("students",studentList);
        return "student_list";
    }

    @GetMapping("/{studentId}")
    public String getStudent(Model model, @PathVariable Integer studentId) {
        Student std = studentService.getStudent(studentId);
        System.out.println("/student/"+studentId+" returned: "+std.getFirstName());

        model.addAttribute("student",std);
        return "student_data";
    }

    @GetMapping("/list")
    public String getStudentList(Model model) {
        List<Student> studentList = studentService.getStudentList();

        model.addAttribute("students",studentList);
        return "student_list";
    }
}
