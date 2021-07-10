package ada.wm2.libraryapp.service;

import ada.wm2.libraryapp.entity.Person;
import ada.wm2.libraryapp.exception.CustomNotFoundException;
import ada.wm2.libraryapp.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepo;


    public void savePerson(Person person) {

        personRepo.save(person);
    }

    public void deletePerson(Person person) {

        personRepo.delete(person);
    }

    public Person findPersonById(Integer id) {
        Person person = personRepo.findById(id).orElseThrow(() -> new CustomNotFoundException("Person not found by given id " + id));
        return person;
    }

    public List<Person> getAllPerson() {
        List<Person> personList = new LinkedList<>();
        personRepo.findAll()
                .forEach(personList::add);
        return personList;
    }

    public void updatePerson(Person person) {
        Person personById = findPersonById(person.getId());
        Person editedPerson = Person.edit(personById, person);
        personRepo.save(editedPerson);

    }




    public List<Person> getPersonLikeName(String name) {

        return personRepo.getPersonByLikeName(name);
    }

    public List<Person> getPersonByAge(Short age) {

        return personRepo.getPersonByAgeLimit(age);
    }

    public List<Person> getPersonByGenderAndSurname(Character gender, String surname) {
        return personRepo.getPersonByGenderAndSurname(gender, surname);
    }

}
