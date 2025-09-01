package com.laserpanda1;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "AUTHOR")
@Data
@Table(name = "AUTHORS")
@NoArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String bio;

    @ManyToMany
    @JoinTable(
            name = "AUTHORS_COURSES", // Имя промежуточной таблицы в БД
            joinColumns = { // Столбцы для текущей сущности (Author)
                    @JoinColumn(
                            name = "author_id", // Имя столбца в таблице AUTHORS_COURSES
                            referencedColumnName = "id", // Имя столбца в таблице AUTHOR
                            nullable = false, // Не может быть null
                            updatable = false // Не может быть изменен
                    )
            },
            inverseJoinColumns = { // Столбцы для связанной сущности (Course)
                    @JoinColumn(
                            name = "course_id", // Имя столбца в таблице AUTHORS_COURSES
                            referencedColumnName = "id", // Имя столбца в таблице COURSE
                            nullable = false, // Не может быть null
                            updatable = false // Не может быть изменен
                    )
            }
    )
    private Set<Course> courses = new HashSet<>();

    public Author(String name, String bio) {
        this.name = name;
        this.bio = bio;
    }
}
