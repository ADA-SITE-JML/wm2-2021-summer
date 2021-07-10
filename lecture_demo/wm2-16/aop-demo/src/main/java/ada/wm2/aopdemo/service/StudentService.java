package ada.wm2.aopdemo.service;

import ada.wm2.aopdemo.annotation.TimeTracker;
import ada.wm2.aopdemo.dto.StudentDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    //@TimeTracker
    public List<StudentDto> getStudentList() {
        List<StudentDto> studentDtoList = new ArrayList<>();
        StudentDto studentDto = new StudentDto("Fagan","Rasulov","SITE");
        studentDtoList.add(studentDto);
        studentDto = new StudentDto("Ismayil","Karimli","SITE");
        studentDtoList.add(studentDto);
        studentDto = new StudentDto("Leyla","Shamoyeva","SITE");
        studentDtoList.add(studentDto);
        System.out.println(studentDtoList);
        return studentDtoList;
    }

}
