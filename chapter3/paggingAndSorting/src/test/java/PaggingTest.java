import com.laserpanda1.Course;
import com.laserpanda1.CourseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PaggingTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void givenDataAvailableWhenLoadFirstPageThenGetFiveRecords() {
        Pageable pageable = PageRequest.of(0,5);
        assertThat(courseRepository.findAll(pageable)).hasSize(5);
        assertThat(pageable.getPageNumber()).isEqualTo(0);

        Pageable nextPageable = pageable.next();
        assertThat(courseRepository.findAll(nextPageable)).hasSize(4);
        assertThat(nextPageable.getPageNumber()).isEqualTo(1);
    }

    @Test
    void givenDataAvailableWhenSortsFirstPageThenGetSortedSData() {
        Pageable pageable = PageRequest.of(0,5, Sort.by("Name"));

        assertThat(courseRepository.findAll(pageable))
                .first()
                .satisfies(course -> {
                    assertThat(course.getId()).isEqualTo(4);
                    assertThat(course.getName()).isEqualTo("DAMN");
                });
    }

    @Test
    void givenDataAvailableWhenApplyCustomSortThenGetSortedResult() {
        Pageable pageable = PageRequest.of(0,5,
                Sort.by("Rating").descending().and(Sort.by("Name")));

        assertThat(courseRepository.findAll(pageable))
                .first()
                .satisfies(course -> {
                    assertThat(course.getId()).isEqualTo(2);
                    assertThat(course.getName()).isEqualTo("DSL");
                });
    }
}
