package com.laserpanda1;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {
   Iterable<Course> findAllByRating(String rating);
   Iterable<Course> findAllByCategoryAndRating(String category, int rating);
}
