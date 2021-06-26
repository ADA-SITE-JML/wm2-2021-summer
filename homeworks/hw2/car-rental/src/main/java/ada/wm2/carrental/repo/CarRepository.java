package ada.wm2.carrental.repo;

import ada.wm2.carrental.entity.Car;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

public interface CarRepository extends CrudRepository<Car, Integer>
{
	@Modifying
	@Transactional //I added these annotations after some StackOverflow search. Not sure exactly what they do.
	@Query(value = "DELETE TOP -1 FROM RENTS WHERE CAR_ID = ?1", nativeQuery = true)
	void deleteCarRenter(Integer carId);
}
