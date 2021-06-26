package ada.wm2.carrental.repo;

import ada.wm2.carrental.entity.Car;
import ada.wm2.carrental.entity.Customer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Integer>
{
	@Query(value = "SELECT CAR_ID FROM RENTS r WHERE r.CUST_ID = ?1", nativeQuery = true)
	List<Integer> getCarsRentedBy(Integer customerId);
	
	@Modifying
	@Transactional //I added these annotations after some StackOverflow search. Not sure exactly what they do.
	@Query(value = "DELETE TOP -1 FROM RENTS WHERE CUST_ID = ?1", nativeQuery = true)
	void deleteCarsOfCustomer(Integer customerId);
	
	@Modifying
	@Transactional
	@Query(value = "DELETE TOP -1 FROM RENTS WHERE CUST_ID = ?1 AND CAR_ID = ?2", nativeQuery = true)
	void deleteRent(Integer customerId, Integer carId);
}
