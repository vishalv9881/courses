package com.example.course.managment.system.controller;


import com.example.course.managment.system.dto.LessonRequestDto;
import com.example.course.managment.system.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/lessons")
public class LessonController {

    @Autowired
    private LessonService lessonService;


    @PostMapping("/course/{courseId}")
    public ResponseEntity<List<LessonRequestDto>> createLessons(
            @PathVariable Long courseId,
            @RequestBody List<LessonRequestDto> lessonDtos) {
        List<LessonRequestDto> createdLessons = lessonService.createMultipleLessons(courseId, lessonDtos);
        return ResponseEntity.ok(createdLessons);
    }


    @GetMapping("show/allLessons/{courseId}")
    public ResponseEntity<List<LessonRequestDto>> getAllLessons(@PathVariable Long courseId) {
        List<LessonRequestDto> lessons = lessonService.getAllLessonsByCourseId(courseId);
        if (lessons.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
        }
        return ResponseEntity.ok(lessons);
    }
}