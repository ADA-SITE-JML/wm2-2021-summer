package ada.wm2.mongodemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collation = "students")
public class Student {
    @Id
    private String id;

    private String firstName;

    private String lastName;

    private Double gpa;

    private String password;
}
