package com.example.course.managment.system.repository;

import com.example.course.managment.system.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {
}
