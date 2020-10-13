package com.laminatimes.util;

public enum RoleEnum {

	ADMIN("ADMIN"), USER("USER");
	//add

	private String role;

	RoleEnum(String role) {
		this.role = role;
	}

	public String getRole() {
		return role;
	}
}
