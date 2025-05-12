package com.example.course.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter

public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="Name cannot be blank")
	private String name;
	
	@NotBlank(message="Email cannot be blank")
	@Email(message="Enter Valid Email")
	private String email;
	
	@NotBlank(message="Password cannot be blank")
	private String password;
	
	@NotNull(message="Phone Number cannot be Null")
	private Long phone;
	
	@NotBlank(message="UserType cannot be blank")
	private String usertype;

	public User(Long id, @NotBlank(message = "Name cannot be blank") String name,
			@NotBlank(message = "Email cannot be blank") @Email(message = "Enter Valid Email") String email,
			@NotBlank(message = "Password cannot be blank") String password,
			@NotNull(message = "Phone Number cannot be Null") Long phone,
			@NotBlank(message = "UserType cannot be blank") String usertype) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.usertype = usertype;
	}

	public User(@NotBlank(message = "Name cannot be blank") String name,
			@NotBlank(message = "Email cannot be blank") @Email(message = "Enter Valid Email") String email,
			@NotBlank(message = "Password cannot be blank") String password,
			@NotNull(message = "Phone Number cannot be Null") Long phone,
			@NotBlank(message = "UserType cannot be blank") String usertype) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.usertype = usertype;
	}

	public User() {
		super();
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", phone=" + phone
				+ ", usertype=" + usertype + "]";
	}

	


}
