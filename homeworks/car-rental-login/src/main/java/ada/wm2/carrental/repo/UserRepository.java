package ada.wm2.carrental.repo;

import ada.wm2.carrental.entity.Customer;
import ada.wm2.carrental.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer>
{
	boolean existsByEmailAndPassword(String email, String password);
	boolean existsByEmail(String email);
	User findByEmail(String email);
}
