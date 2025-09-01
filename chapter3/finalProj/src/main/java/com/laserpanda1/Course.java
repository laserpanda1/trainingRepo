package com.laserpanda1;
import java.util.Set;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;

@Entity(name = "COURSE")
@Data
@Table(name = "COURSES")
public class Course {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String category;

    private int rating;

    private String description;

    @ManyToMany
    public Set<Author> authors = new HashSet<>();

    public Course(String name, String category, int rating, String description) {
        this.name = name;
        this.category = category;
        this.rating = rating;
        this.description = description;
    }
}
