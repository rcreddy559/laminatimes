package com.lamina.user.response;


import javax.persistence.*;

import java.time.LocalDate;

import static com.lamina.user.util.UserUtil.encodePassword;

@Entity(name = "TBL_USER")
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "userName")})
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;
	private String address;
	private String phoneNumber;
	private String email;

	@Column(unique = true, nullable = false, name = "userName")
	private String userName;
	private String password;
	private int active;
	private String gender;
	private int role;

	public User(){}

    public User(int id, String firstName, String lastName, LocalDate dateOfBirth, String address,
				String phoneNumber, String email, String userName, String password, int active, String gender, int role) {
		this( firstName,  lastName,  dateOfBirth,  address, phoneNumber, email, userName, password, active, gender, role);
		this.id = id;
    }

    public User(String firstName, String lastName, LocalDate dateOfBirth,
				String address, String phoneNumber, String email,
				String userName, String password, int active, String gender, int role) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.userName = userName;
		this.password = encodePassword(password);
		this.active = active;
		this.gender= gender;
		this.role = role;
    }

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = encodePassword(password);
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
}
