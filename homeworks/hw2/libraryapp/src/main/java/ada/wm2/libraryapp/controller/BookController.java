package ada.wm2.libraryapp.controller;

import ada.wm2.libraryapp.entity.Book;
import ada.wm2.libraryapp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;


    @GetMapping("/list")
    public String getAllBook(Model model) {
        List<Book> bookList = bookService.getAllBook();
        model.addAttribute("books", bookList);
        return "bookList";
    }

    @PostMapping("/save")
    public String save(Book book, Model model) {
        bookService.saveBook(book);
        List<Book> bookList = bookService.getAllBook();
        model.addAttribute("books", bookList);
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
    public String edit(Book book, Model model) {
        bookService.updateBook(book);
        List<Book> bookList = bookService.getAllBook();
        model.addAttribute("books", bookList);
        return "bookList";
    }
}
