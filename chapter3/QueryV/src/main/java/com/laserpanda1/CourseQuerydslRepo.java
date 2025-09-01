package com.laserpanda1;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseQuerydslRepo extends CrudRepository<Course, Long>,
        QuerydslPredicateExecutor<Course> {

}
