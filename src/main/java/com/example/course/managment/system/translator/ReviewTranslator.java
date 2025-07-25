package com.example.course.managment.system.translator;

import com.example.course.managment.system.dto.ReviewRequestDto;
import com.example.course.managment.system.entity.Review;
import org.springframework.stereotype.Component;

@Component
public class ReviewTranslator {

    public Review translateToEntity(ReviewRequestDto reviewDto) {
        Review review = new Review();
        review.setRating(reviewDto.getRating());
        review.setComment(reviewDto.getComment());
        review.setStudentId(reviewDto.getStudentId());
        return review;
    }

    public ReviewRequestDto translateToDto(Review review) {
        ReviewRequestDto reviewDto = new ReviewRequestDto();
        reviewDto.setRating(review.getRating());
        reviewDto.setComment(review.getComment());
        reviewDto.setStudentId(review.getStudentId());
        return reviewDto;
    }
}