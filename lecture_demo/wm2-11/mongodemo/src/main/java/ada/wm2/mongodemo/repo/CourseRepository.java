package ada.wm2.mongodemo.repo;

import ada.wm2.mongodemo.entity.Course;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CourseRepository extends MongoRepository<Course, String> {
}
