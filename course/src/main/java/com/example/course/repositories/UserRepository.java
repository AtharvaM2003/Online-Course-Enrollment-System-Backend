package com.example.course.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.course.dto.StudentDto;
import com.example.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	boolean existsByEmail(String email);
	
	Optional<User> findByEmail(String Email);
	
	@Query("Select u FROM User u where u.usertype='USER'")
	List<User> findAllStudents();

	@Query("SELECT new com.example.course.dto.StudentDto(u.id, u.name) FROM User u WHERE u.usertype = 'USER'")
	List<StudentDto> fetchAllStudentsNames();
	
	
	@Query("SELECT new com.example.course.dto.StudentDto(u.id, u.name) " +
		       "FROM User u " +
		       "JOIN Enrollment e ON u.id = e.userid " +
		       "JOIN Course c ON e.courseid = c.id " +
		       "WHERE u.usertype = 'USER' AND c.id = ?1")
		List<StudentDto> fetchStudentOfCourses(Long id);


}
