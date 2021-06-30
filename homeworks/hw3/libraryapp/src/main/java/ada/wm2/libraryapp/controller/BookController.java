package ada.wm2.libraryapp.controller;

import ada.wm2.libraryapp.entity.Book;
import ada.wm2.libraryapp.service.BookService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.validation.BindingResult;
import javax.validation.Valid;
import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping("/book")
public class BookController {

    private  Logger log = Logger.getLogger(BookController.class.getName());

    @Autowired
    private BookService bookService;


    @GetMapping("/list")
    public String getAllBook(Model model) {
        log.info("This is getAllBook method");
        List<Book> bookList = bookService.getAllBook();
        log.info("Book service returned list of books");
        model.addAttribute("books", bookList);
        log.info("set books to our model to show it in html");
        return "bookList";
    }

    @PostMapping("/save")
    public String save(@Valid Book book, BindingResult bindingResult, Model model) {
        log.info("Entered to Save Book Method");
        if (bindingResult.hasErrors()){
            log.severe("Error happened while saving a book");
            return "book_add";
        }
        bookService.saveBook(book);
        log.info("Book is saved successfully");
        List<Book> bookList = bookService.getAllBook();
        log.info("Got all book after new book added");
        model.addAttribute("books", bookList);
        log.severe("set books to our model to show it in html");
        return "bookList";
    }

    @GetMapping("/addBook")
    public String addPage(Model model) {
        model.addAttribute("book", new Book());
        return "book_add";
    }


    @GetMapping("/{pId}")
    public String deleteBook(@PathVariable("pId") Integer id, Model model) {
        Book bookById = bookService.findBookById(id);
        bookService.deleteBook(bookById);
        List<Book> bookList = bookService.getAllBook();
        model.addAttribute("books", bookList);
        return "bookList";
    }

    @GetMapping("/edit/{pId}")
    public String editBook(@PathVariable("pId") Integer id, Model model) {
        Book bookById = bookService.findBookById(id);
        model.addAttribute("book", bookById);
        return "book_edit";
    }


    @PostMapping("/edit")
    public String edit(@Valid Book book, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()){
            log.warning("Error happened while editing a book");
            return "book_edit";
        }
        bookService.updateBook(book);
        List<Book> bookList = bookService.getAllBook();
        model.addAttribute("books", bookList);
        return "bookList";
    }
}
