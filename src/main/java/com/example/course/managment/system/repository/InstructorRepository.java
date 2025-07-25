package com.example.course.managment.system.repository;

import com.example.course.managment.system.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor,Long> {
}
