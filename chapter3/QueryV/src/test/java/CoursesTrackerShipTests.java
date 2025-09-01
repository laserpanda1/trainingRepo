import com.laserpanda1.CourseRepoShip;
import com.laserpanda1.DescriptionOnly;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CoursesTrackerShipTests {

    @Autowired
    private CourseRepoShip courseRepoShip;

    @Test
    public void givenACourseAvailableWhenGetCourseByName() {
        Iterable<DescriptionOnly> result =
                courseRepoShip.getCoursesByName("Java Programming");

        assertThat(result)
                .extracting("description").contains("Learn Java programming fundamentals");
    }
}
