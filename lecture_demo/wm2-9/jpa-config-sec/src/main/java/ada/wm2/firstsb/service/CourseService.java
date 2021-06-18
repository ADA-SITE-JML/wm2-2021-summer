package ada.wm2.firstsb.service;

import ada.wm2.firstsb.entity.Course;
import ada.wm2.firstsb.entity.Student;
import ada.wm2.firstsb.repo.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;

    public List<Course> getCourseList() {
        List<Course> courseList = (List<Course>) courseRepository.findAll();

        return courseList;
    }
}
