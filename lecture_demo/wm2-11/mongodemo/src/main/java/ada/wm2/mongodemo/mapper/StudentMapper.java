package ada.wm2.mongodemo.mapper;

import ada.wm2.mongodemo.dto.StudentDTO;
import ada.wm2.mongodemo.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    @Mapping(source = "id", target = "studentId")
    StudentDTO studentToDTO(Student student);
}
