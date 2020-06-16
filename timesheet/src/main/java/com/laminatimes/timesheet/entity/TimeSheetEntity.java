package com.laminatimes.timesheet.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TimeSheetEntity {

    private Long id;
    private Long userId;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate date;
    private List<TimeSheetProjectEntity> timeSheetProjects = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<TimeSheetProjectEntity> getTimeSheetProjects() {
        return timeSheetProjects;
    }

    public void setTimeSheetProjects(List<TimeSheetProjectEntity> timeSheetProjects) {
        this.timeSheetProjects = timeSheetProjects;
    }

    @Override
    public String toString() {
        return "TimeSheetEntity{" +
                "id=" + id +
                ", userId=" + userId +
                ", date=" + date +
                ", timeSheetProjects=" + timeSheetProjects +
                '}';
    }
}
