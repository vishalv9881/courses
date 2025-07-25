package com.example.course.managment.system.dto;

import lombok.*;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourseResponseDto {
    private String name;
    private String description;
    private String duration;
    private Double coursePrice;

}

