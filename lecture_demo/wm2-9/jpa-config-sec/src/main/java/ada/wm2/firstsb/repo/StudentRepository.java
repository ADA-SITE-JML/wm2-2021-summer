package ada.wm2.firstsb.repo;

import ada.wm2.firstsb.entity.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface StudentRepository extends CrudRepository<Student,Integer> {
    Optional<Student> findByFirstNameAndLastName(String firstName, String LastName);

    Iterable<Student> findByFirstNameOrLastName(String firstName,String lastName);

    @Query("Select s from Student s where s.lastName like '%va'")
    Iterable<Student> findAllGirls();

}
