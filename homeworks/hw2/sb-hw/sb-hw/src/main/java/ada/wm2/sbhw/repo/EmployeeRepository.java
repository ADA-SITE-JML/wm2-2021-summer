package ada.wm2.sbhw.repo;

import ada.wm2.sbhw.entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}
