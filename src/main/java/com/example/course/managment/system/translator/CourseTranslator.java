package com.example.course.managment.system.translator;

import com.example.course.managment.system.dto.CourseRequestDto;
import com.example.course.managment.system.dto.CourseResponseDto;
import com.example.course.managment.system.entity.*;

import com.example.course.managment.system.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CourseTranslator {

    @Autowired
    private InstructorRepository instructorRepository;


    public Course dtoToEntity(CourseRequestDto dto) {
        Course course = new Course();
        course.setName(dto.getName());
        course.setDescription(dto.getDescription());
        course.setDuration(dto.getDuration());
        course.setCoursePrice(dto.getCoursePrice());

        // Set Instructor
        Instructor instructor = new Instructor();
        instructor.setName(dto.getInstructor().getName());

        InstructorContactDetails contactDetails = new InstructorContactDetails();
        contactDetails.setEmail(dto.getInstructor().getInstructorContactDetails().getEmail());
        contactDetails.setPhoneNumber(dto.getInstructor().getInstructorContactDetails().getPhoneNumber());
        contactDetails.setAddress(dto.getInstructor().getInstructorContactDetails().getAddress());
        contactDetails.setCity(dto.getInstructor().getInstructorContactDetails().getCity());
        contactDetails.setState(dto.getInstructor().getInstructorContactDetails().getState());
        contactDetails.setPinCode(dto.getInstructor().getInstructorContactDetails().getPinCode());
        contactDetails.setCountry(dto.getInstructor().getInstructorContactDetails().getCountry());

        instructor.setInstructorContactDetails(contactDetails);
        course.setInstructor(instructor);


        return course;

    }


    public CourseResponseDto entityToDto(Course course) {
        CourseResponseDto dto = new CourseResponseDto();
        dto.setName(course.getName());
        dto.setDescription(course.getDescription());
        dto.setDuration(course.getDuration());
        dto.setCoursePrice(course.getCoursePrice());
        return dto;
    }
}
