package com.example.course.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.course.dto.StudentDto;
import com.example.course.entities.User;

@Service
public interface UserService {

	List<User> findAllUser();
	
	boolean existsByEmail(String email);
	
	User findByEmail(String Email);
	
	User findUserById(Long id);
	
	User createUser(User user);
	
	User updateUser(Long id, User updated);
	
	boolean deleteUser(Long id);
	
	List<StudentDto> fetchAllStudentsNames();
	
	List<User> findAllStudents();
	
	List<StudentDto> fetchStudentOfCourses(Long id);
}
