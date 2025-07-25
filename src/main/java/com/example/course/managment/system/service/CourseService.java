package com.example.course.managment.system.service;


import com.example.course.managment.system.dto.CourseRequestDto;
import com.example.course.managment.system.dto.CourseResponseDto;
import com.example.course.managment.system.entity.Course;
import com.example.course.managment.system.repository.CourseRepository;
import com.example.course.managment.system.translator.CourseTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseTranslator courseTranslator;

    public CourseResponseDto createCourse(CourseRequestDto courseRequestDto) {
        Course course = courseTranslator.dtoToEntity(courseRequestDto);
        course = courseRepository.save(course);
        return courseTranslator.entityToDto(course);

    }

    public ResponseEntity<CourseResponseDto> getCourseById(Long courseId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        CourseResponseDto courseResponseDto = courseTranslator.entityToDto(course);
        return ResponseEntity.ok(courseResponseDto);
    }

    public List<CourseResponseDto> getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        return courses.stream()
                .map(course -> courseTranslator.entityToDto(course))
                .collect(Collectors.toList());
    }

}
