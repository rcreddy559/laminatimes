package com.laminatimes.leaves.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "company_leaves")

public class CompanyLeaves implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CompanyLeaves(){}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "leave_type")
	private String leaveType;
	
	@Column(name = "noofdays")
	private int noOfDays;
	
	@Column(name = "employee_type")
	private String employeeType;
	
	
	@Column(name = "created_by")
	private String createdBy;
	
	@Column(name = "created_date")
	private java.time.LocalDate  createDate;
	
	@Column(name = "modified_by")
	private String modifiedBy;
	
	@Column(name = "modified_date")
	private java.time.LocalDate  modifiedDate;
	
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "employee_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

	public int getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}

	public String getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public java.time.LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(java.time.LocalDate createDate) {
		this.createDate = createDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public java.time.LocalDate getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(java.time.LocalDate modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
	
	@Override
	public String toString() {
		return "CompanyLeaves [id=" + id + ", leaveType=" + leaveType + ", noOfDays=" + noOfDays + ", employeeType="
				+ employeeType + ", createdBy=" + createdBy + ", createDate=" + createDate + ", modifiedBy="
				+ modifiedBy + ", modifiedDate=" + modifiedDate + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result + ((createdBy == null) ? 0 : createdBy.hashCode());
		result = prime * result + ((employeeType == null) ? 0 : employeeType.hashCode());
		result = prime * result + id;
		result = prime * result + ((leaveType == null) ? 0 : leaveType.hashCode());
		result = prime * result + ((modifiedBy == null) ? 0 : modifiedBy.hashCode());
		result = prime * result + ((modifiedDate == null) ? 0 : modifiedDate.hashCode());
		result = prime * result + noOfDays;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompanyLeaves other = (CompanyLeaves) obj;
		if (createDate == null) {
			if (other.createDate != null)
				return false;
		} else if (!createDate.equals(other.createDate))
			return false;
		if (createdBy == null) {
			if (other.createdBy != null)
				return false;
		} else if (!createdBy.equals(other.createdBy))
			return false;
		if (employeeType == null) {
			if (other.employeeType != null)
				return false;
		} else if (!employeeType.equals(other.employeeType))
			return false;
		if (id != other.id)
			return false;
		if (leaveType == null) {
			if (other.leaveType != null)
				return false;
		} else if (!leaveType.equals(other.leaveType))
			return false;
		if (modifiedBy == null) {
			if (other.modifiedBy != null)
				return false;
		} else if (!modifiedBy.equals(other.modifiedBy))
			return false;
		if (modifiedDate == null) {
			if (other.modifiedDate != null)
				return false;
		} else if (!modifiedDate.equals(other.modifiedDate))
			return false;
		if (noOfDays != other.noOfDays)
			return false;
		return true;
	}
	
	
}






	