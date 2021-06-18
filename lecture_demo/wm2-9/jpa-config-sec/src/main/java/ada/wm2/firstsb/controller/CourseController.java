package ada.wm2.firstsb.controller;

import ada.wm2.firstsb.entity.Course;
import ada.wm2.firstsb.entity.Student;
import ada.wm2.firstsb.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {
    @Autowired
    CourseService courseService;

    @GetMapping("/list")
    public String getCourseList(Model model) {
        List<Course> courseList = courseService.getCourseList();

        model.addAttribute("courses",courseList);
        return "course_list";
    }
}
