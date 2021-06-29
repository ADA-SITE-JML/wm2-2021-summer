package ada.wm2.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    private Integer studentId;

    private String firstName;

    private String lastName;

    private Double gpa;
}
