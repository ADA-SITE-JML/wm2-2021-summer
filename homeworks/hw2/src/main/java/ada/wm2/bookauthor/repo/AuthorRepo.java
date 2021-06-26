package ada.wm2.bookauthor.repo;

import ada.wm2.bookauthor.entity.AuthorEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface AuthorRepo extends CrudRepository<AuthorEntity, Integer>
{
    @Query(value = "select B_ID from PUBLISHMENT where A_ID = :id",nativeQuery = true)
    ArrayList<Integer> getbooks(Integer id);
    
}
