package ada.wm2.firstsb.repo;

import ada.wm2.firstsb.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student,Integer> {

}
