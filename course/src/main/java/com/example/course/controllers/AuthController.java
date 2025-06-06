package com.example.course.controllers;

import java.util.HashMap;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.course.dto.LoginDto;
import com.example.course.dto.ResponseToken;
import com.example.course.entities.User;
import com.example.course.exceptions.UserAlreadyExistsException;
import com.example.course.security.JwtUtils;
import com.example.course.services.UserService;


@RestController
@RequestMapping("/auth")
public class AuthController {

	AuthenticationManager authenticationManager;
	UserService userService;
	PasswordEncoder passwordEncoder;
	JwtUtils jwtService;

	@Autowired
	public AuthController(AuthenticationManager authenticationManager, UserService userService,
			PasswordEncoder passwordEncoder, JwtUtils jwtService) {
		this.userService = userService;
		this.authenticationManager = authenticationManager;
		this.passwordEncoder = passwordEncoder;
		this.jwtService = jwtService;
	}

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@RequestBody LoginDto loginDto) {
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));

		if (authentication.isAuthenticated()) {
			User user = userService.findByEmail(loginDto.getUsername());
			Map<String, Object> claims = new HashMap<>();
			claims.put("email", user.getEmail());
			claims.put("userid", user.getId());
			claims.put("usertype", user.getUsertype());
			String token = jwtService.generateToken(loginDto.getUsername(), claims);
			ResponseToken responseToken = new ResponseToken(token);
			return ResponseEntity.status(HttpStatus.OK).body(responseToken);
		}
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("You are not Authorized !!");
	}

	@PostMapping("/register")
	public ResponseEntity<User> registerUser(@RequestBody User user) {
		if (userService.existsByEmail(user.getEmail()))
			throw new UserAlreadyExistsException("Username or Email Exists !");
		user.setPassword(passwordEncoder.encode(user.getPassword()));

		return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(user));
	}
//	@PatchMapping("/users/{id}/password")
//	public ResponseEntity<String> updatePassword(@PathVariable Long id, @RequestBody String pass) {
//	   
//
//	    if (pass == null || pass.isBlank()) {
//	        return ResponseEntity.badRequest().body("Password cannot be empty");
//	    }
//
//	    Optional<User> optionalUser = userService.findUserById(id);
//	    if (optionalUser.isEmpty()) {
//	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
//	    }
//
//	    User user = optionalUser.get();
//	    user.setPassword(passwordEncoder.encode(pass));
//	    userService.updateUser(id, user);
//
//	    return ResponseEntity.ok("Password updated successfully");
//	}

}
