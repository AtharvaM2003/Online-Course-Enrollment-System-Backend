package com.example.course.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.course.dto.InstructorCourseDto;
import com.example.course.dto.InstructorWiseStudentDto;
import com.example.course.entities.Course;
import com.example.course.entities.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {

	@Query("SELECT i.name FROM Instructor i WHERE i.id = ?1")
	List<String> findInstructorName(Long id);

	@Query("SELECT c.title FROM Course c where c.instructorid=?1")
	List<String> fetchInstructorCourses(Long id);

	@Query("SELECT new com.example.course.dto.InstructorWiseStudentDto(COUNT(e.userid), i.name) " +
		       "FROM Enrollment e " +
		       "JOIN Course c ON c.id = e.courseid " +
		       "JOIN Instructor i ON c.instructorid = i.id " +
		       "GROUP BY i.name")
	List<InstructorWiseStudentDto> fetchInstructorWiseStudentCount();

	
}
