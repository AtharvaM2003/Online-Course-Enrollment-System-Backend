package com.example.course.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentDetailsDto {
    private Long id;
    private String studentName;
    private String courseTitle;
    private LocalDate enrollmentDate;
}
