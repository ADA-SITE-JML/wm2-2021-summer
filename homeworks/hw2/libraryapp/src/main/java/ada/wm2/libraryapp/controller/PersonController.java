package ada.wm2.libraryapp.controller;

import ada.wm2.libraryapp.entity.Book;
import ada.wm2.libraryapp.entity.Person;
import ada.wm2.libraryapp.service.BookService;
import ada.wm2.libraryapp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/person")
public class PersonController {


    @Autowired
    private PersonService personService;

    @Autowired
    private BookService bookService;


    @GetMapping("/list")
    public String getAllPerson(Model model) {
        List<Person> allPerson = personService.getAllPerson();
        model.addAttribute("persons", allPerson);

        return "personList";
    }

    @GetMapping("/books/{stId}")
    public String getPurchasedBooks(@PathVariable("stId") Integer id, Model model) {
        Person personById = personService.findPersonById(id);
        String concat = personById.getName().concat(" " + personById.getSurname());
        List<Book> purchasedBookByPerson = bookService.findPurchasedBookByPerson(id);
        model.addAttribute("books", purchasedBookByPerson);
        model.addAttribute("bookList", bookService.unAssignedBooks(id));
        model.addAttribute("userId", id);
        model.addAttribute("taker", concat);
        return "purchased_list";
    }

    @GetMapping("/book/remove/")
    public String removeBookFromPerson(@RequestParam("stId") Integer stId, @RequestParam("id") Integer bookId, Model model) {
        Person personById = personService.findPersonById(stId);
        String concat = personById.getName().concat(" " + personById.getSurname());
        bookService.removeBook(bookId);
        List<Book> purchasedBookByPerson = bookService.findPurchasedBookByPerson(stId);
        model.addAttribute("books", purchasedBookByPerson);
        model.addAttribute("bookList", bookService.unAssignedBooks(stId));
        model.addAttribute("userId", stId);
        model.addAttribute("taker", concat);
        return "purchased_list";
    }

    @GetMapping("/book/add/")
    public String addBookToPerson(@RequestParam("stId") Integer stId, @RequestParam("id") Integer bookId, Model model) {
        Person personById = personService.findPersonById(stId);
        String concat = personById.getName().concat(" " + personById.getSurname());
        bookService.addBookToPerson(stId, bookId);
        List<Book> purchasedBookByPerson = bookService.findPurchasedBookByPerson(stId);
        model.addAttribute("books", purchasedBookByPerson);
        model.addAttribute("bookList", bookService.unAssignedBooks(stId));
        model.addAttribute("userId", stId);
        model.addAttribute("taker", concat);
        return "purchased_list";
    }

    @PostMapping("/save")
    public String save(Person person, Model model) {
        personService.savePerson(person);
        List<Person> allPerson = personService.getAllPerson();
        model.addAttribute("persons", allPerson);
        return "personList";
    }

    @GetMapping("/addPerson")
    public String addPage(Model model) {
        model.addAttribute("person", new Person());
        return "person_add";
    }

    @GetMapping("/{pId}")
    public String deletePerson(@PathVariable("pId") Integer id, Model model) {
        Person personById = personService.findPersonById(id);
        personService.deletePerson(personById);
        List<Person> allPerson = personService.getAllPerson();
        model.addAttribute("persons", allPerson);
        return "personList";
    }

    @GetMapping("/edit/{pId}")
    public String editPerson(@PathVariable("pId") Integer id, Model model) {
        Person personById = personService.findPersonById(id);
        model.addAttribute("person", personById);
        return "person_edit";
    }


    @PostMapping("/edit")
    public String edit(Person person, Model model) {
        personService.updatePerson(person);
        List<Person> allPerson = personService.getAllPerson();
        model.addAttribute("persons", allPerson);
        return "personList";
    }

    @GetMapping("/likeName")
    public String getPersonsByName(@RequestParam String name, Model model) {
        List<Person> personLikeName = personService.getPersonLikeName(name);
        model.addAttribute("persons", personLikeName);
        return "personList";
    }

    @GetMapping("/greater")
    public String getPersonsByAge(@RequestParam Short age, Model model) {
        List<Person> personByAge = personService.getPersonByAge(age);
        model.addAttribute("persons", personByAge);
        return "personList";
    }

    @GetMapping("/gender/surname")
    public String getPersonByGenderAndSurname(@RequestParam Character gender, @RequestParam String surname, Model model) {
        List<Person> personByGenderAndSurname = personService.getPersonByGenderAndSurname(gender, surname);
        model.addAttribute("persons", personByGenderAndSurname);
        return "personList";
    }

    @GetMapping("/searchPage")
    public String getSearchPage() {
        return "search";
    }

}
