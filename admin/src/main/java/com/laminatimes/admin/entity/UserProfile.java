package com.laminatimes.admin.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)

public class UserProfile {

	public UserProfile(){}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "USER_NAME")
	private String userName;

	@Column(name = "EMP_NUMBER")
	private String empNumber;

	@Column(name = "ABOUT_USER")
	private String aboutUser;
	@Column(name = "CITY")
	private String city;

	@Column(name = "CLIENT_NAME")
	private String clientName;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "COUNTRY")
	private String country;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "HOME_PHONE_NUMBER")
	private String homePhoneNumber;

	@Column(name = "INSURANCE_NUMBER")
	private String insuranceNumber;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "PASSPORT_NUMBER")
	private String passportNumber;

	@Column(name = "PERSONAL_EMAIL")
	private String personalEmail;

	@Column(name = "POST_CODE")
	private String postCode;

	@Column(name = "PREFIX")
	private String prefix;

	@Column(name = "SUFFIX")
	private String suffix;

	@Column(name = "PROJECT_END_DATE")
	private String projectEndDate;

	@Column(name = "PROJECT_NAME")
	private String projectName;

	@Column(name = "PROJECT_START_DATE")
	private String projectStartDate;

	@Column(name = "ROLE_ID")
	private String roleId;

	@Column(name = "SOCIAL_SECURITY_NUMBER")
	private String socialSecurityNumber;

	@Column(name = "HIRE_DATE")
	private String hireDate;

	@Column(name = "END_DATE")
	private String endDate;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "TAX_ID")
	private String taxId;

	@Column(name = "SKILLS")
	private String skills;

	@Column(name = "WORK_EMAIL")
	private String workEmail;

	@Column(name = "WORK_PHONE_NUMBER")
	private String workPhoneNumber;

	@Column(name = "POSITION")
	private String position;

	@Column(name = "GENDER")
	private String gender;

	@Column(name = "BIRTH_DAY")
	private String birthDay;

	@Column(name = "ACTIVE")
	private int active;
	

	public UserProfile( String userName, String empNumber, String aboutUser, String city, String clientName,
			String password, String country, String firstName, String homePhoneNumber, String insuranceNumber,
			String lastName, String passportNumber, String personalEmail, String postCode, String prefix, String suffix,
			String projectEndDate, String projectName, String projectStartDate, String roleId,
			String socialSecurityNumber, String hireDate, String endDate, String address, String taxId, String skills,
			String workEmail, String workPhoneNumber, String position, String gender, String birthDay, int active) {
		super();
		this.userName = userName;
		this.empNumber = empNumber;
		this.aboutUser = aboutUser;
		this.city = city;
		this.clientName = clientName;
		this.password = password;
		this.country = country;
		this.firstName = firstName;
		this.homePhoneNumber = homePhoneNumber;
		this.insuranceNumber = insuranceNumber;
		this.lastName = lastName;
		this.passportNumber = passportNumber;
		this.personalEmail = personalEmail;
		this.postCode = postCode;
		this.prefix = prefix;
		this.suffix = suffix;
		this.projectEndDate = projectEndDate;
		this.projectName = projectName;
		this.projectStartDate = projectStartDate;
		this.roleId = roleId;
		this.socialSecurityNumber = socialSecurityNumber;
		this.hireDate = hireDate;
		this.endDate = endDate;
		this.address = address;
		this.taxId = taxId;
		this.skills = skills;
		this.workEmail = workEmail;
		this.workPhoneNumber = workPhoneNumber;
		this.position = position;
		this.gender = gender;
		this.birthDay = birthDay;
		this.active = active;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmpNumber() {
		return empNumber;
	}

	public void setEmpNumber(String empNumber) {
		this.empNumber = empNumber;
	}

	public String getAboutUser() {
		return aboutUser;
	}

	public void setAboutUser(String aboutUser) {
		this.aboutUser = aboutUser;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getHomePhoneNumber() {
		return homePhoneNumber;
	}

	public void setHomePhoneNumber(String homePhoneNumber) {
		this.homePhoneNumber = homePhoneNumber;
	}

	public String getInsuranceNumber() {
		return insuranceNumber;
	}

	public void setInsuranceNumber(String insuranceNumber) {
		this.insuranceNumber = insuranceNumber;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getPersonalEmail() {
		return personalEmail;
	}

	public void setPersonalEmail(String personalEmail) {
		this.personalEmail = personalEmail;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getProjectEndDate() {
		return projectEndDate;
	}

	public void setProjectEndDate(String projectEndDate) {
		this.projectEndDate = projectEndDate;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectStartDate() {
		return projectStartDate;
	}

	public void setProjectStartDate(String projectStartDate) {
		this.projectStartDate = projectStartDate;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	public void setSocialSecurityNumber(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTaxId() {
		return taxId;
	}

	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getWorkEmail() {
		return workEmail;
	}

	public void setWorkEmail(String workEmail) {
		this.workEmail = workEmail;
	}

	public String getWorkPhoneNumber() {
		return workPhoneNumber;
	}

	public void setWorkPhoneNumber(String workPhoneNumber) {
		this.workPhoneNumber = workPhoneNumber;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getGender() {
		return gender;
	}

	public void setGendar(String gender) {
		this.gender = gender;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public int getActive() {
		return active;
	}

	public void setActiv(int active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "UserProfile [id=" + id + ", userName=" + userName + ", empNumber=" + empNumber + ", aboutUser="
				+ aboutUser + ", city=" + city + ", clientName=" + clientName + ", password=" + password + ", country="
				+ country + ", firstName=" + firstName + ", homePhoneNumber=" + homePhoneNumber + ", insuranceNumber="
				+ insuranceNumber + ", lastName=" + lastName + ", passportNumber=" + passportNumber + ", personalEmail="
				+ personalEmail + ", postCode=" + postCode + ", prefix=" + prefix + ", suffix=" + suffix
				+ ", projectEndDate=" + projectEndDate + ", projectName=" + projectName + ", projectStartDate="
				+ projectStartDate + ", roleId=" + roleId + ", socialSecurityNumber=" + socialSecurityNumber
				+ ", hireDate=" + hireDate + ", endDate=" + endDate + ", address=" + address + ", taxId=" + taxId
				+ ", skills=" + skills + ", workEmail=" + workEmail + ", workPhoneNumber=" + workPhoneNumber
				+ ", position=" + position + ", gender=" + gender + ", birthDay=" + birthDay + ", active=" + active + "]";
	}

	

}
