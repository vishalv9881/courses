package com.example.course.managment.system.controller;


import com.example.course.managment.system.dto.CourseRequestDto;
import com.example.course.managment.system.dto.CourseResponseDto;
import com.example.course.managment.system.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping("/create")
    public ResponseEntity<CourseResponseDto> createCourse(@RequestBody CourseRequestDto courseRequestDto) {
        CourseResponseDto createdCourse = courseService.createCourse(courseRequestDto);
        return ResponseEntity.ok(createdCourse);
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<CourseResponseDto> getCourseById(@PathVariable Long courseId) {
        CourseResponseDto courseResponseDto = courseService.getCourseById(courseId).getBody();
        if (courseResponseDto != null) {
            return ResponseEntity.ok(courseResponseDto);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping("/courses")
    public ResponseEntity<List<CourseResponseDto>> getAllCourses() {
        List<CourseResponseDto> responseList = courseService.getAllCourses();
        return ResponseEntity.ok(responseList);
    }


}
