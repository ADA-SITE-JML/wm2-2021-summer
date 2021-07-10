package ada.wm2.firstsb.repo;

import ada.wm2.firstsb.entity.Patient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PatientRepository extends CrudRepository <Patient, Integer>{

    Optional<Patient> findByFirstNameAndLastName(String firstName,String lastName);
    Iterable<Patient> findByFirstNameOrLastName(String firstName,String lastName);

    @Query("Select p from Patient p where p.lastName like '%va'")
    Iterable<Patient> findAllGirls();




}
