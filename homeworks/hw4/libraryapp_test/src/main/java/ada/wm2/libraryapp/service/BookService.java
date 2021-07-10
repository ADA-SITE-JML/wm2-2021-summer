package ada.wm2.libraryapp.service;

import ada.wm2.libraryapp.entity.Book;
import ada.wm2.libraryapp.exception.CustomNotFoundException;
import ada.wm2.libraryapp.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Service
public class BookService {


    @Autowired
    private BookRepository bookRepo;


    public void saveBook(Book book) {


        bookRepo.save(book);
    }

    public void deleteBook(Book book) {

        bookRepo.delete(book);
    }

    public Book findBookById(Integer id) {
        Book book = bookRepo.findById(id).orElseThrow(() -> new CustomNotFoundException("Book not found by given id " + id));
        return book;
    }



    public List<Book> getAllBook() {
        List<Book> bookList = new LinkedList<>();
        bookRepo.findAll()
                .forEach(e -> bookList.add(e));
        return bookList;
    }

    public void updateBook(Book book) {
        Book bookById = findBookById(book.getId());
        Book editedBook = Book.editBook(bookById, book);
        bookRepo.save(editedBook);
    }



    public List<Book> findPurchasedBookByPerson(Integer id) {
        List<Book> bookList = new LinkedList<>();
        bookRepo.findAll()
                .forEach(e -> {
                    if (Objects.nonNull(e.getPerson())) {
                        if (e.getPerson().getId().equals(id)) {
                            bookList.add(e);
                        }
                    }
                });
        return bookList;
    }



    public void removeBook(Integer bookId) {
        bookRepo.removeBook(bookId);
    }

    public List<Book> unAssignedBooks(Integer id) {
        List<Book> bookList = new LinkedList<>();
        bookRepo.findAll()
                .forEach(e -> {
                    if (Objects.isNull(e.getPerson()) || !e.getPerson().getId().equals(id)) {
                        bookList.add(e);
                    }
                });
        return bookList;
    }

    public void addBookToPerson(Integer personId, Integer bookId) {
        bookRepo.addBook(personId, bookId);
    }
}
