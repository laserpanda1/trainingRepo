package com.laserpanda1;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {

    @Query("SELECT c FROM Course c WHERE c.category=?1")
    Iterable<Course> findAllByCategory(String category);

    @Query("SELECT c FROM Course c WHERE c.category=:category and c.rating >:rating")
    Iterable<Course> findAllByCategoryAndRatingGreaterThan (@Param("category") String category,
                                                            @Param("rating") int rating);

    @Query(value = "SELECT * FROM Course WHERE rating=?1", nativeQuery = true)
    Iterable<Course> findAllByRating(int rating);

    @Modifying
    @Transactional
    @Query("UPDATE Course c SET c.rating=:rating where c.name=:name")
    int updateCourseRatingByName(@Param("rating") int rating,
                                 @Param("name") String name);
}
