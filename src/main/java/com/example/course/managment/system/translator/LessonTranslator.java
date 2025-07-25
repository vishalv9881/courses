package com.example.course.managment.system.translator;

import com.example.course.managment.system.dto.LessonRequestDto;
import com.example.course.managment.system.entity.Lesson;
import org.springframework.stereotype.Component;

@Component
public class LessonTranslator {

    public Lesson translateToEntity(LessonRequestDto lessonRequestDto) {
        Lesson lesson= new Lesson();
        lesson.setTitle(lessonRequestDto.getTitle());
        lesson.setContent(lessonRequestDto.getContent());
        lesson.setDuration(lessonRequestDto.getDuration());
        lesson.setVideoUrl(lessonRequestDto.getVideoUrl());
        return lesson;
    }

    public LessonRequestDto translateToDto(Lesson lesson) {
        LessonRequestDto lessonRequestDto = new LessonRequestDto();
        lessonRequestDto.setTitle(lesson.getTitle());
        lessonRequestDto.setContent(lesson.getContent());
        return lessonRequestDto;
    }

}
