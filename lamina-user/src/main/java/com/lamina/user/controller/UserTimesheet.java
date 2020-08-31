package com.lamina.user.controller;

import java.util.Collections;
import java.util.List;

public class UserTimesheet {
    private User user;
    private List<Leave> leaves;
    private List<Holiday> holidays;

    public UserTimesheet() {
    	this.user = new User();
        this.leaves = Collections.EMPTY_LIST;
        this.holidays = Collections.EMPTY_LIST;
    }
    public UserTimesheet(User user, List<Leave> leaves, List<Holiday> holidays) {
        this.user = user;
        this.leaves = leaves;
        this.holidays = holidays;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setLeaves(List<Leave> leaves) {
        this.leaves = leaves;
    }

    public void setHolidays(List<Holiday> holidays) {
        this.holidays = holidays;
    }

    public User getUser() {
        return user;
    }

    public List<Leave> getLeaves() {
        return leaves;
    }

    public List<Holiday> getHolidays() {
        return holidays;
    }
}
