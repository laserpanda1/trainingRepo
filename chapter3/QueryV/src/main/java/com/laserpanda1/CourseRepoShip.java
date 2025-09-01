package com.laserpanda1;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepoShip extends CrudRepository<Course,Long> {
    Iterable<DescriptionOnly> getCoursesByName(String name);
}
