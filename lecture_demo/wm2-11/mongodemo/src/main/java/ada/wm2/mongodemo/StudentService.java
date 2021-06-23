package ada.wm2.mongodemo;

import ada.wm2.mongodemo.dto.StudentDTO;
import ada.wm2.mongodemo.entity.Student;
import ada.wm2.mongodemo.mapper.StudentMapper;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    public void testLombok() {
        Student std = new Student("2","Aynur","Ganbarli",3.2,"abc123");
        StudentDTO stdDTO = StudentMapper.INSTANCE.studentToDTO(std);
    }
}
