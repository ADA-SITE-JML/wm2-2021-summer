package ada.wm2.tst.repo;

import ada.wm2.tst.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student,Integer> {
}
