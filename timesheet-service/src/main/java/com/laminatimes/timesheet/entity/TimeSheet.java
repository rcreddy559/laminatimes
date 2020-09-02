package com.laminatimes.timesheet.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class TimeSheet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long userId;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate date;

    @OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private List<TimeSheetProject> timeSheetProjects = new ArrayList<>();

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

    public List<TimeSheetProject> getTimeSheetProjects() {
        return timeSheetProjects;
    }

    public void setTimeSheetProjects(List<TimeSheetProject> timeSheetProjects) {
        this.timeSheetProjects = timeSheetProjects;
    }

    @Override
    public String toString() {
        return "TimeSheet{" +
                "id=" + id +
                ", userId=" + userId +
                ", date=" + date +
                ", timeSheetProjects=" + timeSheetProjects +
                '}';
    }
}
