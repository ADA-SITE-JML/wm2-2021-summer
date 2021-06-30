package ada.wm2.rest.mapper;

import ada.wm2.rest.dto.StudentDTO;
import ada.wm2.rest.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    @Mapping(source = "id", target = "studentId")
    StudentDTO studentToDTO(Student student);

    @Mapping(source = "id", target = "studentId")
    List<StudentDTO> studentListToDTO(Iterable<Student> studentList);

    @Mapping(source = "studentId", target = "id")
    Student StudentDTOToEntity(StudentDTO studentDTO);
}
