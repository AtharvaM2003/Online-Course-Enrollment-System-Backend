package com.example.course.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.course.dto.InstructorCourseDto;
import com.example.course.dto.InstructorDto;
import com.example.course.dto.InstructorWiseStudentDto;
import com.example.course.entities.Instructor;

@Service
public interface InstructorService {
	
	List<Instructor> findAllInstructor();
	
	Instructor findInstructorById(Long id);
	
	Instructor createInstructor(Instructor instructor);
	
	Instructor updateInstructor(Instructor instructor, Long id);
	
	boolean deleteInstructor(Long id);
	
	List<String> findInstructorName(Long id);
	
	List<InstructorDto> findAllInstructorDto();

	List<String> fetchInstructorCourses(Long id);
	
	List<InstructorWiseStudentDto> fetchInstructorWiseStudentCount();

}
