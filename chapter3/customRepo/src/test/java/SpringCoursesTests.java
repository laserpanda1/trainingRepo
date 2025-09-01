import com.laserpanda1.Course;
import com.laserpanda1.CustomizedCourseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class SpringCoursesTests {

    @Autowired
    private CustomizedCourseRepository courseRepository;

    @Test
    public void givenCreateCourseWhenFindAllCoursesThenExpectOneCourse() {
        Course course = new Course("Rapid Spring boot",
                "cat233", 5, "GOOD BOOK BRO");

        courseRepository.save(course);
        assertThat(Arrays.asList(courseRepository.findAll()).size()).isEqualTo(1);


    }
}
