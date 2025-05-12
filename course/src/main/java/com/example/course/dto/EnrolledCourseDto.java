package com.example.course.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class EnrolledCourseDto {
	
	private String courseTitle;
	private String instructorName;
	private LocalDate enrollmentDate;
	private Double courseFees;
	

}
