package com.example.course.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.course.dto.DashboardDto;
import com.example.course.services.AdminService;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin(origins = "*")
public class DashboardController {
	
	AdminService adminService;

	@Autowired
	public DashboardController(AdminService adminService) {
		super();
		this.adminService = adminService;
	}
	
	@GetMapping
	public ResponseEntity<DashboardDto> findAllfetchDashboardCount(){
		return ResponseEntity.status(HttpStatus.OK).body(adminService.fetchDashboardCount());
	}
	

}
