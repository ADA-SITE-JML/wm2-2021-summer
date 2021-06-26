package ada.wm2.sbhw.repo;

import ada.wm2.sbhw.entity.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task,Integer> {
}
