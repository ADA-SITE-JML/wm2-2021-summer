package ada.wm2.mongodemo.repo;

import ada.wm2.mongodemo.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Student,String> {

    @Query("{ 'gpa' : { $gt: ?0, $lt: ?1 } }")
    List<Student> findStudentsByGpaBetween(double gpaMin, double gpaMax);
}
