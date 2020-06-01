package com.laminatimes.admin.util;

public enum RoleEnum {

	ADMIN("ADMIN"), USER("USER");

	private String role;

	RoleEnum(String role) {
		this.role = role;
	}

	public String getRole() {
		return role;
	}
}
