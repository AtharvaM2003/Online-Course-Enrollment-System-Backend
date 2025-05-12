package com.example.course.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.course.dto.AvailableCourseDto;
import com.example.course.dto.CourseDto;
import com.example.course.dto.CourseEnrollmentReportDto;
import com.example.course.dto.EnrolledCourseDto;
import com.example.course.dto.Top5CoursesDto;
import com.example.course.entities.Course;
import com.example.course.entities.Instructor;
import com.example.course.exceptions.CourseNotFoundException;
import com.example.course.exceptions.InstructorNotFoundException;
import com.example.course.repositories.CourseRepository;
import com.example.course.repositories.InstructorRepository;

@Service
public class CourseServiceImple implements CourseService {

	private final CourseRepository courseRepo;
private InstructorRepository instructorRepository;
	
	
	@Autowired
	public CourseServiceImple(CourseRepository courseRepo,InstructorRepository instructorRepository) {
		super();
		this.courseRepo = courseRepo;
		this.instructorRepository=instructorRepository;
	}

	@Override
	public List<CourseDto> findAllCourses() {
		
		return courseRepo.findAllCourses();
	}

	@Override
	public Course findCourseById(Long id) {
		
		return courseRepo.findById(id).orElseThrow(()->new CourseNotFoundException("Course not found with Id"+id));
		
	}

	@Override
	public Course createCourse(Course course) {
		
		return courseRepo.save(course);
	}

	@Override
	public Course updateCourse(Course updated, Long id) {
		Course existing=courseRepo.findById(id).
				orElseThrow(()->new CourseNotFoundException("Course not found with Id"+id));
		existing.setInstructorid(updated.getInstructorid());
		existing.setTitle(updated.getTitle());
		existing.setDescription(updated.getDescription());
		existing.setFees(updated.getFees());
		
		return courseRepo.save(existing);
	}

	@Override
	public boolean deleteCourse(Long id) {
		if(!courseRepo.existsById(id)) {
			throw new CourseNotFoundException("Course not found with Id"+id);
			
		}
		courseRepo.deleteById(id);
		return false;
	}

	@Override
	public List<CourseEnrollmentReportDto> getCourseEnrollmentReport() {
	
		return courseRepo.getCourseEnrollmentReport();
	}

	@Override
	public List<EnrolledCourseDto> enrolledCoursesByStudent(Long studentId) {
	
		return courseRepo.enrolledCoursesByStudent(studentId);
	}

	@Override
	public List<AvailableCourseDto> findCoursesWithIsEnrollment(Long userId) {
		return courseRepo.findCoursesWithIsEnrollment(userId);
	}

	@Override
	public List<Top5CoursesDto> findTop5Courses() {
	
		return courseRepo.findTop5Courses();
	}
	

}
