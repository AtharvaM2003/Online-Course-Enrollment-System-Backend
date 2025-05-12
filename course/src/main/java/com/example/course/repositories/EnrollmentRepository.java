package com.example.course.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.course.dto.CourseInfoDto;
import com.example.course.dto.EnrollmentDetailsDto;
import com.example.course.entities.Course;
import com.example.course.entities.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long>{
	
	List<Enrollment> findByUserid(Long userid);
	@Query("SELECT new com.example.course.dto.EnrollmentDetailsDto(e.id, u.name, c.title, e.enrollmentdate) " +
            "FROM Enrollment e, User u, Course c " +
            "WHERE e.userid = u.id AND e.courseid = c.id AND u.usertype = 'USER'")
	List<EnrollmentDetailsDto> fetchEnrollmentDetails();
	
	@Query(value = "SELECT c.title as title, c.description as description " +
            "FROM course c " +
            "JOIN enrollment e ON c.id = e.courseid " +
            "WHERE e.userid = :studentId", nativeQuery = true)
	List<CourseInfoDto> findCoursesByStudentId(@Param("studentId") Long studentId);


}
