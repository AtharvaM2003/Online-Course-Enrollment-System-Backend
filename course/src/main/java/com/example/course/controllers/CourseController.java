package com.example.course.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.course.dto.AvailableCourseDto;
import com.example.course.dto.CourseDto;
import com.example.course.dto.CourseEnrollmentReportDto;
import com.example.course.dto.EnrolledCourseDto;
import com.example.course.dto.Top5CoursesDto;
import com.example.course.entities.Course;
import com.example.course.services.CourseService;

@RestController
@RequestMapping("/api/courses")
@CrossOrigin(origins = "*") 
public class CourseController {
	
	private final CourseService courseService;
	

	@Autowired
	public CourseController(CourseService courseService) {
		super();
		this.courseService = courseService;
		
	}

	
	@GetMapping("/findTop5Courses")
	public ResponseEntity<List<Top5CoursesDto>> findTop5Courses(){
		List<Top5CoursesDto> top5Courses=courseService.findTop5Courses();
		return ResponseEntity.status(HttpStatus.OK).body(top5Courses);
	}
	
	@GetMapping
	public ResponseEntity<List<CourseDto>> findAllCourses(){
		List<CourseDto> courseList=courseService.findAllCourses();
		return ResponseEntity.status(HttpStatus.OK).body(courseList);
	}
	
	@GetMapping("/enrolled/{userid}")
	public ResponseEntity<List<EnrolledCourseDto>> enrolledCoursesByStudent(@PathVariable Long userid){
		List<EnrolledCourseDto> enrolledCourses=courseService.enrolledCoursesByStudent(userid);
		return ResponseEntity.status(HttpStatus.OK).body(enrolledCourses);
	}
	
	@GetMapping("/available/{userid}")
	public ResponseEntity<List<AvailableCourseDto>> findCoursesWithIsEnrollment(@PathVariable Long userid){
		List<AvailableCourseDto> availableCourses=courseService.findCoursesWithIsEnrollment(userid);
		return ResponseEntity.status(HttpStatus.OK).body(availableCourses);
	}
	

	@GetMapping("/{id}")
	public ResponseEntity<Course> findCourseById(@PathVariable Long id){
		Course course=courseService.findCourseById(id);
		return ResponseEntity.status(HttpStatus.OK).body(course);
	}
	
	@PostMapping
	public ResponseEntity<Course> createCourse(@RequestBody Course course){
		Course save=courseService.createCourse(course);
		return ResponseEntity.status(HttpStatus.CREATED).body(save);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Course> updateCourse(@PathVariable Long id,@RequestBody Course course){
		Course newIntructor=courseService.updateCourse(course, id);
		return ResponseEntity.status(HttpStatus.OK).body(newIntructor);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Course> deleteCourse(@PathVariable Long id){
		courseService.deleteCourse(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	@GetMapping("/coursereport")
	public ResponseEntity<List<CourseEnrollmentReportDto>> getCourseEnrollmentReport(){
		List<CourseEnrollmentReportDto> report=courseService.getCourseEnrollmentReport();
		return ResponseEntity.status(HttpStatus.OK).body(report);
	}
	

}
