package com.laminatimes.leaves.entity;

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
@Table(name = "leaves")

public class Leaves {
	public Leaves(){}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "leave_name")
	private String leaveName;
	
	@Column(name = "start_date")
	private java.time.LocalDate  startDate;
	
	@Column(name = "end_date")
	private java.time.LocalDate  endDate;
	
	@Column(name = "noofdays")
	private int noOfDays;
	
	@Column(name = "comments")
	private String comments;
	
	@Column(name = "approver_cmts")
	private String approverComments;
	
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
    private User employeeUser;
	
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "approver_id",   referencedColumnName = "manager_id",nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Project approverUser;


	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getLeaveName() {
		return leaveName;
	}


	public void setLeaveName(String leaveName) {
		this.leaveName = leaveName;
	}


	public java.time.LocalDate getStartDate() {
		return startDate;
	}


	public void setStartDate(java.time.LocalDate startDate) {
		this.startDate = startDate;
	}


	public java.time.LocalDate getEndDate() {
		return endDate;
	}


	public void setEndDate(java.time.LocalDate endDate) {
		this.endDate = endDate;
	}


	public int getNoOfDays() {
		return noOfDays;
	}


	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}


	public String getComments() {
		return comments;
	}


	public void setComments(String comments) {
		this.comments = comments;
	}


	public String getApproverComments() {
		return approverComments;
	}


	public void setApproverComments(String approverComments) {
		this.approverComments = approverComments;
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


	public User getEmployeeUser() {
		return employeeUser;
	}


	public void setEmployeeUser(User employeeUser) {
		this.employeeUser = employeeUser;
	}


	public Project getApproverUser() {
		return approverUser;
	}


	public void setApproverUser(Project approverUser) {
		this.approverUser = approverUser;
	}


	@Override
	public String toString() {
		return "Leaves [id=" + id + ", leaveName=" + leaveName + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", noOfDays=" + noOfDays + ", comments=" + comments + ", approverComments=" + approverComments
				+ ", createdBy=" + createdBy + ", createDate=" + createDate + ", modifiedBy=" + modifiedBy
				+ ", modifiedDate=" + modifiedDate + ", employeeUser=" + employeeUser + ", approverUser=" + approverUser
				+ ", getId()=" + getId() + ", getLeaveName()=" + getLeaveName() + ", getStartDate()=" + getStartDate()
				+ ", getEndDate()=" + getEndDate() + ", getNoOfDays()=" + getNoOfDays() + ", getComments()="
				+ getComments() + ", getApproverComments()=" + getApproverComments() + ", getCreatedBy()="
				+ getCreatedBy() + ", getCreateDate()=" + getCreateDate() + ", getModifiedBy()=" + getModifiedBy()
				+ ", getModifiedDate()=" + getModifiedDate() + ", getEmployeeUser()=" + getEmployeeUser()
				+ ", getApproverUser()=" + getApproverUser() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((approverComments == null) ? 0 : approverComments.hashCode());
		result = prime * result + ((approverUser == null) ? 0 : approverUser.hashCode());
		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result + ((createdBy == null) ? 0 : createdBy.hashCode());
		result = prime * result + ((employeeUser == null) ? 0 : employeeUser.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + id;
		result = prime * result + ((leaveName == null) ? 0 : leaveName.hashCode());
		result = prime * result + ((modifiedBy == null) ? 0 : modifiedBy.hashCode());
		result = prime * result + ((modifiedDate == null) ? 0 : modifiedDate.hashCode());
		result = prime * result + noOfDays;
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
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
		Leaves other = (Leaves) obj;
		if (approverComments == null) {
			if (other.approverComments != null)
				return false;
		} else if (!approverComments.equals(other.approverComments))
			return false;
		if (approverUser == null) {
			if (other.approverUser != null)
				return false;
		} else if (!approverUser.equals(other.approverUser))
			return false;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
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
		if (employeeUser == null) {
			if (other.employeeUser != null)
				return false;
		} else if (!employeeUser.equals(other.employeeUser))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (id != other.id)
			return false;
		if (leaveName == null) {
			if (other.leaveName != null)
				return false;
		} else if (!leaveName.equals(other.leaveName))
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
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		return true;
	}



	
}






	