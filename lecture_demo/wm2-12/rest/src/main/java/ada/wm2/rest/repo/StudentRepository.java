package ada.wm2.rest.repo;

import ada.wm2.rest.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student,Integer> {
}
