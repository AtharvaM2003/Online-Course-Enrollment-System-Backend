package com.example.course.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InstructorCourseDto {
	
	    private Long instructorId;
	    private String instructorName;
	    private String expertise;
	    private String courseTitle;

	   
	
}
