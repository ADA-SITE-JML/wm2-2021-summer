package ada.wm2.mongodemo.mapper;

import ada.wm2.mongodemo.dto.StudentDTO;
import ada.wm2.mongodemo.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    @Mapping(source="stId",target = "studentId")
    StudentDTO studentToDTO(Student student);

    List<StudentDTO> studentListToDTO(List<Student> studentList);

}
