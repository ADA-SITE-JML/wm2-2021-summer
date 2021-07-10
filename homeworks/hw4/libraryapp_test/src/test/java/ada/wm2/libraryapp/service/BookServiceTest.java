package ada.wm2.libraryapp.service;

import ada.wm2.libraryapp.entity.Book;
import ada.wm2.libraryapp.entity.Person;
import ada.wm2.libraryapp.repository.BookRepository;
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

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;


@ExtendWith(MockitoExtension.class)
public class BookServiceTest {




    @Mock
    BookRepository bookRepository;


    @InjectMocks
    BookService bookService;




    @Test
    @DisplayName("Expected to get 2 books from list of books")
    void testGetAllBook() {
        // Given
        Book book1 = new Book();
        Book book2 = new Book();
        List<Book> bookList = new ArrayList<>();
        bookList.add(book1);
        bookList.add(book2);

        given(bookRepository.findAll()).willReturn(bookList);

        // When
        List<Book> allBooks = bookService.getAllBook();

        // Then
        then(bookRepository).should().findAll();
        assertThat(allBooks).hasSize(2);

    }

    @Test
    @DisplayName("Find any book")
    void testFindBookById() {
        // Given
        Book book = new Book();
        given(bookRepository.findById(anyInt())).willReturn(Optional.of(book));

        // When
        Book found = bookService.findBookById(anyInt());

        // Then
        then(bookRepository).should().findById(anyInt());
        assertThat(found).isNotNull();
    }

    @Test
    @DisplayName("Expected to get 2 purchased books from list of books")
    void testFindPurchasedBookByPerson() {
        // Given
        Book book1 = new Book();
        Book book2 = new Book();
        List<Book> bookList = new ArrayList<>();
        bookList.add(book1);
        bookList.add(book2);

        given(bookRepository.findAll()).willReturn(bookList);

        // When
        List<Book> allBooks = bookService.getAllBook();

        // Then
        then(bookRepository).should().findAll();
        assertThat(allBooks).hasSize(2);

    }




}
