import com.laserpanda1.Course;
import com.laserpanda1.CourseRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CourseTrackerSpringBootCriteriaTest {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    public void givenCoursesCreatedWhenLoadCoursesWithQueryThenExpectCorrectCourseDetails() {
            courseRepository.saveAll(getCourseList());

        CriteriaBuilder criteriaBuilder =
                entityManager.getCriteriaBuilder();

        CriteriaQuery<Course> criteriaQuery =
                criteriaBuilder.createQuery(Course.class);

        Root<Course> root = criteriaQuery.from(Course.class);

        Predicate predicate = criteriaBuilder.equal(
                root.get("category"), "Spring");

        criteriaQuery.where(predicate);

        TypedQuery<Course> query =
                entityManager.createQuery(criteriaQuery);


        Assertions.assertThat(query.getResultList().size()).isEqualTo(3);

    }

    private List<Course> getCourseList() {
        return List.of(
                new Course("Scalable, Cloud Native Data Applications",
                        "Spring", 4,
                        "Manage Cloud based applications with Spring Boot"),
                new Course("Java Programming",
                        "Java", 5,
                        "Learn Java programming fundamentals"),
                new Course("Web Development",
                        "JavaScript", 3,
                        "Frontend and backend web development")
        );
    }
}
