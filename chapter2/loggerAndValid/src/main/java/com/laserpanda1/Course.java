package com.laserpanda1;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class Course {

    private long id;
    private String name;
    private String category;

    @Min(value = 1, message = "Minimum 1 rating")
    @Max(value = 5, message = "Maximum 5 rating")
    private int rating;

    private String description;


}
