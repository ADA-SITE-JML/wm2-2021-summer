package ada.wm2.libraryapp.repository;

import ada.wm2.libraryapp.entity.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Integer> {

    @Query(value = "select s from Person s where s.name like %:name%")
    List<Person> getPersonByLikeName(String name);

    @Query(value = "select s from Person s where s.age > :age")
    List<Person> getPersonByAgeLimit(Short age);

    @Query(value = "select s from Person s where s.gender = :gender and s.surname like %:surname%")
    List<Person> getPersonByGenderAndSurname(Character gender, String surname);

}
