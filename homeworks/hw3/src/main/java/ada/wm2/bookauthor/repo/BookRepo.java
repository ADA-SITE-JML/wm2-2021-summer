package ada.wm2.bookauthor.repo;

import ada.wm2.bookauthor.entity.BookEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

public interface BookRepo extends CrudRepository<BookEntity, Integer>
{
    @Query(value = "SELECT BOOK_NAME FROM BOOKS where B_ID = :id",nativeQuery = true)
    public String getBookByID(Integer id);
}
