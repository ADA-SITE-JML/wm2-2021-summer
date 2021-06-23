package ada.wm2.firstsb.service;

import ada.wm2.firstsb.entity.Student;
import ada.wm2.firstsb.repo.StudentRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    StudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    @Test
    void getStudentList() {
        // Given
        Student std1 = new Student();
        Student std2 = new Student();
        List<Student> stdList = new ArrayList<>();
        stdList.add(std1);
        stdList.add(std2);
        given(studentRepository.findAll()).willReturn(stdList);

        // When
        List<Student> allStudents = studentService.getStudentList();

        // Then
        then(studentRepository).should().findAll();
        assertThat(allStudents).hasSize(2);
    }

    @Test
    void getStudent() {
        // Given
        Student std = new Student();
        given(studentRepository.findById(anyInt())).willReturn(Optional.of(std));

        // When
        Student found = studentService.getStudent(anyInt());

        // Then
        then(studentRepository).should().findById(anyInt());
        assertThat(found).isNotNull();
    }

    @Test
    void saveStudent() {
        // Given
        Student std = new Student();
        given(studentRepository.save(std)).willReturn(std);

        // When
        Student saved = studentService.saveStudent(std);

        // Then
        then(studentRepository).should().save(any(Student.class));
        assertThat(saved).isNotNull();
    }
}