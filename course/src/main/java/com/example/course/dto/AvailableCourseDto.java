package com.example.course.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor

public class AvailableCourseDto {



	private Long id;

	private String title;
	
	private String description;

	private Long instructorid;
	
	private String instructorName;
	
	private Double fees;
	
	private boolean isEnrolled;


}
