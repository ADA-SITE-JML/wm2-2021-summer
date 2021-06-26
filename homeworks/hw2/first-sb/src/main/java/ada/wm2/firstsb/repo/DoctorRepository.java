package ada.wm2.firstsb.repo;

import ada.wm2.firstsb.entity.Doctor;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DoctorRepository extends CrudRepository<Doctor, Integer> {
//    Optional<Doctor> findByFirstNameAndLastName(String firstName, String lastName);
//    Iterable<Doctor> findByFirstNameOrLastName(String firstName,String lastName);





}
