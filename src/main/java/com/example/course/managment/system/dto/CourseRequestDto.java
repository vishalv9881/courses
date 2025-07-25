package com.example.course.managment.system.dto;

import com.example.course.managment.system.entity.Instructor;
import com.example.course.managment.system.entity.InstructorContactDetails;
import com.example.course.managment.system.entity.Lesson;
import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CourseRequestDto {
    private String name;
    private String description;
    private Instructor instructor;
    private String duration;
    private Lesson lesson;
    private Double coursePrice;

    private InstructorContactDetails instructorContactDetails;

}
