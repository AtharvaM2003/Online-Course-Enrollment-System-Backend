package com.example.course.services;

import java.util.List;


import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.example.course.dto.AvailableCourseDto;
import com.example.course.dto.CourseDto;
import com.example.course.dto.CourseEnrollmentReportDto;
import com.example.course.dto.EnrolledCourseDto;
import com.example.course.dto.Top5CoursesDto;
import com.example.course.entities.Course;

@Service
public interface CourseService {

	List<CourseDto> findAllCourses();
	
	Course findCourseById(Long id);
	
	Course createCourse(Course course);
	
	Course updateCourse(Course course, Long id);
	
	boolean deleteCourse(Long id);
	
	List<CourseEnrollmentReportDto> getCourseEnrollmentReport();
	
	List<EnrolledCourseDto> enrolledCoursesByStudent(Long studentId);
	
	List<AvailableCourseDto> findCoursesWithIsEnrollment(Long userId);
	
	List<Top5CoursesDto> findTop5Courses();


}
