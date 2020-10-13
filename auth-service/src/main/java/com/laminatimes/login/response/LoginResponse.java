package com.laminatimes.login.response;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.laminatimes.entity.Role;

public class LoginResponse implements Serializable {
	private static final long serialVersionUID = 1L;

	private HttpStatus status;
	private String errorCode;
	private String description;
	private String sessionKey;
	private Role role;
	private String email;
	private String empId;
	private String firstName;
	private String lastName;
	private String position;
	
	 @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
	 private LocalDateTime timestamp;

	
	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSessionKey() {
		return sessionKey;
	}

	public void setSessionKey(String sessionKey) {
		this.sessionKey = sessionKey;
	}

	@Override
	public String toString() {
		return "LoginResponse [status=" + status + ", errorCode=" + errorCode + ", description=" + description
				+ ", sessionKey=" + sessionKey + ", role=" + role + ", email=" + email + ", empId=" + empId
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", position=" + position + "]";
	}
}
