package com.example.course.managment.system.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewRequestDto {
    private int rating;
    private String comment;
    private Long studentId;
}
