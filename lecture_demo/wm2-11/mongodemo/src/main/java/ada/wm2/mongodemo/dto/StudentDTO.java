package ada.wm2.mongodemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    String studentId;

    String firstName;

    String lastName;

    Double gpa;
}
