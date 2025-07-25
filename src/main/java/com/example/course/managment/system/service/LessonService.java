package com.example.course.managment.system.service;

import com.example.course.managment.system.dto.LessonRequestDto;
import com.example.course.managment.system.entity.Course;
import com.example.course.managment.system.entity.Lesson;
import com.example.course.managment.system.repository.CourseRepository;
import com.example.course.managment.system.repository.LessonRepository;
import com.example.course.managment.system.translator.LessonTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LessonService {

    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private LessonTranslator lessonTranslator;

    // Single Lesson creation (if needed separately)
    public LessonRequestDto createLesson(Long courseId, LessonRequestDto lessonRequestDto) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        Lesson lesson = lessonTranslator.translateToEntity(lessonRequestDto);
        lesson.setCourse(course);
        lesson = lessonRepository.save(lesson);

        return lessonTranslator.translateToDto(lesson);
    }

    // Multiple Lessons creation
    public List<LessonRequestDto> createMultipleLessons(Long courseId, List<LessonRequestDto> lessonDtos) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        List<Lesson> lessons = lessonDtos.stream()
                .map(dto -> {
                    Lesson lesson = lessonTranslator.translateToEntity(dto);
                    lesson.setCourse(course); // Set foreign key reference
                    return lesson;
                })
                .collect(Collectors.toList());

        List<Lesson> savedLessons = lessonRepository.saveAll(lessons);

        return savedLessons.stream()
                .map(lessonTranslator::translateToDto)
                .collect(Collectors.toList());
    }


    public List<LessonRequestDto> getAllLessonsByCourseId(Long courseId) {

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        List<Lesson> lessons = lessonRepository.findByCourse(course);

        return lessons.stream()
                .map(lessonTranslator::translateToDto)
                .collect(Collectors.toList());
    }
}
