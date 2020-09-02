package com.lamina.user.controller;

public class Leave {

    private int id;

    private String leaveName;

    private java.time.LocalDate startDate;

    private java.time.LocalDate endDate;

    private int noOfDays;

    private String comments;

    private String approverComments;

    private String createdBy;

    private java.time.LocalDate createDate;

    private String modifiedBy;

    private java.time.LocalDate modifiedDate;

    private int employeeId;

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

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return "Leave {" +
                "  id=" + id +
                ", leaveName='" + leaveName + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", noOfDays=" + noOfDays +
                ", comments='" + comments + '\'' +
                ", approveComments='" + approverComments + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", createDate=" + createDate +
                ", modifiedBy='" + modifiedBy + '\'' +
                ", modifiedDate=" + modifiedDate +
                ", employeeId=" + employeeId +
                '}';
    }
}
