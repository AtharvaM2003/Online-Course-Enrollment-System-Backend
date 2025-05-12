package com.example.course.dto;

import java.util.Objects;

public class DashboardDto {
	int studentCount;
	int instructorCount;
	int courseCount;
	
	
	
	
	public DashboardDto() {
		super();
	}


	public DashboardDto(int studentCount, int instructorCount, int courseCount) {
		super();
		this.studentCount = studentCount;
		this.instructorCount = instructorCount;
		this.courseCount = courseCount;
	}


	public int getStudentCount() {
		return studentCount;
	}


	public void setStudentCount(int studentCount) {
		this.studentCount = studentCount;
	}


	public int getInstructorCount() {
		return instructorCount;
	}


	public void setInstructorCount(int instructorCount) {
		this.instructorCount = instructorCount;
	}


	public int getCourseCount() {
		return courseCount;
	}


	public void setCourseCount(int courseCount) {
		this.courseCount = courseCount;
	}


	@Override
	public String toString() {
		return "DashboardDto [studentCount=" + studentCount + ", instructorCount=" + instructorCount + ", courseCount="
				+ courseCount + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(courseCount, instructorCount, studentCount);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof DashboardDto))
			return false;
		DashboardDto other = (DashboardDto) obj;
		return courseCount == other.courseCount && instructorCount == other.instructorCount
				&& studentCount == other.studentCount;
	}
	
	
	

}
