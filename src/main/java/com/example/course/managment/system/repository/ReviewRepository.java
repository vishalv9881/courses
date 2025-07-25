package com.example.course.managment.system.repository;

import com.example.course.managment.system.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Long> {
}
