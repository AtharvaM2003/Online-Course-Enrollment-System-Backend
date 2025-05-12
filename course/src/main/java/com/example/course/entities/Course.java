package com.example.course.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="Title should not be blank")
	private String title;
	
	@NotBlank(message="Description should not be blank")
	private String description;
	
	@NotNull(message="Instructor should not be Null")
	private Long instructorid;
	
	@NotNull(message="Fee should not be Null")
	@Positive(message ="Fees should be positive")
	private Double fees;



	

}
