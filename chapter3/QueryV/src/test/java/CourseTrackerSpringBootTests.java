import com.laserpanda1.Course;
import com.laserpanda1.CourseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CourseTrackerSpringBootTests {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void givenCoursesCreatedWhenLoadCoursesWithQueryThenExpectCorrectCourseDetails() {
        saveMockCourses();
        assertThat(courseRepository.findAllByCategory("Spring")).hasSize(1);
        assertThat(courseRepository.findAllByRating(5)).hasSize(1);
        assertThat(courseRepository.findAllByCategoryAndRatingGreaterThan
                ("Spring", 3)).hasSize(2);
        assertThat(courseRepository.updateCourseRatingByName(4, "Java Programming"));

    }

    private List<Course> saveMockCourses() {
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
