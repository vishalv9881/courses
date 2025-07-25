package com.example.course.managment.system.service;


import com.example.course.managment.system.dto.ReviewRequestDto;
import com.example.course.managment.system.entity.Course;
import com.example.course.managment.system.entity.Review;
import com.example.course.managment.system.repository.CourseRepository;
import com.example.course.managment.system.repository.ReviewRepository;
import com.example.course.managment.system.translator.ReviewTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ReviewTranslator reviewTranslator;
    public ReviewRequestDto addReview(Long courseId, ReviewRequestDto dto) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        Review review = reviewTranslator.translateToEntity(dto);
        review.setCourse(course); // link the review with course

        review = reviewRepository.save(review);

        return reviewTranslator.translateToDto(review);
    }
}


