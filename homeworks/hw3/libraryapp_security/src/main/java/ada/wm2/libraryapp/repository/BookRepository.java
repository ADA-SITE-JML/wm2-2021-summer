package ada.wm2.libraryapp.repository;

import ada.wm2.libraryapp.entity.Book;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

public interface BookRepository extends CrudRepository<Book, Integer> {

    @Transactional
    @Modifying
    @Query(value = "update book set PERSON_ID =null where id =?1", nativeQuery = true)
    void removeBook(Integer bookId);


    @Transactional
    @Modifying
    @Query(value = "update book set PERSON_ID =?1 where id =?2", nativeQuery = true)
    void addBook(Integer personId, Integer bookId);
}
