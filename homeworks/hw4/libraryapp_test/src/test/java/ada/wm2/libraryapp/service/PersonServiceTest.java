package ada.wm2.libraryapp.service;

import ada.wm2.libraryapp.entity.Person;
import ada.wm2.libraryapp.repository.PersonRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.anyShort;
import static org.mockito.ArgumentMatchers.anyChar;


@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {


    @Mock
    PersonRepository personRepository;


    @InjectMocks
    PersonService personService;


    @Test
    @DisplayName("Expected to get 3 people from list of person")
    void testGetAllPerson() {
        // Given
        Person person1 = new Person();
        Person person2 = new Person();
        Person person3 = new Person();
        List<Person> peopleList = new ArrayList<>();
        peopleList.add(person1);
        peopleList.add(person2);
        peopleList.add(person3);
        given(personRepository.findAll()).willReturn(peopleList);

        // When
        List<Person> allPerson = personService.getAllPerson();

        // Then
        then(personRepository).should().findAll();
        assertThat(allPerson).hasSize(3);

    }

    @Test
    @DisplayName("Find any person")
    void testFindPersonById() {
        // Given
        Person person = new Person();
        given(personRepository.findById(anyInt())).willReturn(Optional.of(person));

        // When
        Person found = personService.findPersonById(anyInt());

        // Then
        then(personRepository).should().findById(anyInt());
        assertThat(found).isNotNull();
    }

    @Test
    @DisplayName("Expected to get 2 people from list of person")
    void testGetPersonLikeName() {
        // Given
        Person personLikeName1 = new Person();
        Person personLikeName2 = new Person();
        List<Person> peopleLikeNameList = new ArrayList<>();
        peopleLikeNameList.add(personLikeName1);
        peopleLikeNameList.add(personLikeName2);
        given(personRepository.getPersonByLikeName(anyString())).willReturn(peopleLikeNameList);

        // When
        List<Person> allPersonLikeName = personService.getPersonLikeName(anyString());


        // Then
        then(personRepository).should().getPersonByLikeName(anyString());
        assertThat(allPersonLikeName).hasSize(2);

    }


    @Test
    @DisplayName("Expected to get 2 people from list of person by age limit")
    void testGetPersonByAge() {
        // Given
        Person personByAge1 = new Person();
        Person personByAge2 = new Person();
        List<Person> personByAgeList = new ArrayList<>();
        personByAgeList.add(personByAge1);
        personByAgeList.add(personByAge2);
        given(personRepository.getPersonByAgeLimit(anyShort())).willReturn(personByAgeList);

        // When
        List<Person> allPersonLikeName = personService.getPersonByAge(anyShort());


        // Then
        then(personRepository).should().getPersonByAgeLimit(anyShort());
        assertThat(allPersonLikeName).hasSize(2);

    }


    @Test
    @DisplayName("Expected to get 3 people from list of person by Gender and Surname")
    void testGetPersonByGenderAndSurname() {
        // Given
        Person personByGenderAndSurname1 = new Person();
        Person personByGenderAndSurname2 = new Person();
        Person personByGenderAndSurname3 = new Person();

        List<Person> personByGenderAndSurnameList = new ArrayList<>();
        personByGenderAndSurnameList.add(personByGenderAndSurname1);
        personByGenderAndSurnameList.add(personByGenderAndSurname2);
        personByGenderAndSurnameList.add(personByGenderAndSurname3);
        given(personRepository.getPersonByGenderAndSurname(anyChar(),anyString())).willReturn(personByGenderAndSurnameList);

        // When
        List<Person> allPersonLikeName = personService.getPersonByGenderAndSurname(anyChar(),anyString());


        // Then
        then(personRepository).should().getPersonByGenderAndSurname(anyChar(),anyString());
        assertThat(allPersonLikeName).hasSize(3);

    }


}
