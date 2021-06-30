package ada.wm2.firstsb.repo;

import ada.wm2.firstsb.entity.Game;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<Game,Integer> {
}
