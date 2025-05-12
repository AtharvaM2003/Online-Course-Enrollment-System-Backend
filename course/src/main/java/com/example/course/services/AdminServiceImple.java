package com.example.course.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.course.dto.DashboardDto;
import com.example.course.repositories.CourseRepository;
import com.example.course.repositories.InstructorRepository;
import com.example.course.repositories.UserRepository;

@Service
public class AdminServiceImple implements AdminService{

	CourseRepository courseRepository;
	InstructorRepository instructorRepository;
	UserRepository userRepository;
	
	
	@Autowired
	public AdminServiceImple(CourseRepository courseRepository, InstructorRepository instructorRepository,
			UserRepository userRepository) {
		super();
		this.courseRepository = courseRepository;
		this.instructorRepository = instructorRepository;
		this.userRepository = userRepository;
	}



	@Override
	public DashboardDto fetchDashboardCount() {
		DashboardDto dto = new DashboardDto();
		dto.setCourseCount(courseRepository.findAll().size());
		dto.setInstructorCount(instructorRepository.findAll().size());
		dto.setStudentCount(userRepository.findAllStudents().size());

		return dto;
	}

}
