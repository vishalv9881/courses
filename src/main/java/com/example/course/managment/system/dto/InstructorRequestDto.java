package com.example.course.managment.system.dto;

import com.example.course.managment.system.entity.InstructorContactDetails;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class InstructorRequestDto {
    private String name;
    private InstructorContactDetails instructorContactDetails;
}
