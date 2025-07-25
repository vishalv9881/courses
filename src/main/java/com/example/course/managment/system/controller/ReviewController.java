package com.example.course.managment.system.controller;

import com.example.course.managment.system.dto.ReviewRequestDto;
import com.example.course.managment.system.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/course/{courseId}")
    public ResponseEntity<ReviewRequestDto> addReview(
            @PathVariable Long courseId,
            @RequestBody ReviewRequestDto dto) {
        ReviewRequestDto createdReview = reviewService.addReview(courseId, dto);
        return ResponseEntity.ok(createdReview);
    }


    @GetMapping("/course/{courseId}")
    public ResponseEntity<ReviewRequestDto> getReviewByCourseId(@PathVariable Long courseId) {
        ReviewRequestDto review = reviewService.getReviewByCourseId(courseId);
        if (review != null) {
            return ResponseEntity.ok(review);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @GetMapping("/course/{courseId}/reviews")
    public ResponseEntity<ReviewRequestDto> getAllReviewsByCourseId(@PathVariable Long courseId) {
        ReviewRequestDto review = reviewService.getReviewByCourseId(courseId);
        if (review != null) {
            return ResponseEntity.ok(review);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
