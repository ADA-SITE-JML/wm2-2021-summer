package ada.wm2.firstsb.service;

import ada.wm2.firstsb.bean.StudentBean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    public List<StudentBean> getStudentList() {
        List<StudentBean> studentList = new ArrayList<>();

        studentList.add(new StudentBean("Sevinj","Jafarli"));
        studentList.add(new StudentBean("Hasan","Nagiyev"));
        studentList.add(new StudentBean("Anar","Huseynov"));
        studentList.add(new StudentBean("Narmina","Huseynli"));
        studentList.add(new StudentBean("Kamran","Rzayev"));

        return studentList;
    }
}
