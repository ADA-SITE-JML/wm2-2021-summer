package ada.wm2.bookauthor.service;

import ada.wm2.bookauthor.entity.BookEntity;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import ada.wm2.bookauthor.bean.AuthorBean;
import ada.wm2.bookauthor.entity.AuthorEntity;
import ada.wm2.bookauthor.repo.AuthorRepo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AuthorServiceTest {

    @Mock
    AuthorRepo authorRepo;

    @InjectMocks
    AuthorService  authorService;

    @Test
    @DisplayName("Find all Author")
    void testGetAllAuthors() {
        //Given
        AuthorEntity ath1 = new AuthorEntity();
        AuthorEntity ath2 = new AuthorEntity();
        List<AuthorEntity> athList = new ArrayList<>();
        athList.add(ath1);
        athList.add(ath2);
        given(authorRepo.findAll()).willReturn(athList);

        //When
        List<AuthorBean> allAuthorEntities = authorService.getAllAuthors();

        //Then
        then(authorRepo).should().findAll();
        assertThat(allAuthorEntities).hasSize(2);

    }

    @Test
    @DisplayName("Expect to get the saved Author")
    void testSaveAuthor() {
        //Given
        AuthorEntity ath = new AuthorEntity();
        given(authorRepo.save(ath)).willReturn(ath);

        //When
        AuthorEntity saved = authorService.saveAuthor(ath);

        //Then
        then(authorRepo).should().save(any(AuthorEntity.class));
        assertThat(saved).isNotNull();
    }

//    @Test
//    @DisplayName("Expect to get 2 book name for author id = 1")
//    void testGetBookNames() {
//        Integer author_id = 1;
//
//        List<String> expected = new ArrayList<>();
//        expected.add("1984");
//        expected.add("To Kill a Mockingbird");
//
//        AuthorEntity authorEntity1 = new AuthorEntity(1, "Elnur", "01.01.1951");
//        BookEntity bookEntity1 = new BookEntity(1, "1984", "01.01.1948");
//        BookEntity bookEntity2 = new BookEntity(2, "To Kill a Mockingbird", "11.07.1960");
//        authorEntity1.setBooks(new HashSet<>());
//        authorEntity1.getBooks().add(bookEntity1);
//        authorEntity1.getBooks().add(bookEntity2);
//
//        authorService.saveAuthor(authorEntity1);
//
//        Set<BookEntity> books = authorService.getAuthorEntityWithID(author_id).getBooks();
//        List<String> result = new ArrayList<>();
//        for(BookEntity bookEntity: books) {
//            result.add(bookEntity.getName());
//        }
//        assertEquals(expected, result);
//
//        System.out.println(result);
//
//    }
}