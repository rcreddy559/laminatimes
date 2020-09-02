package com.laminatimes.timesheet.service;

import com.laminatimes.timesheet.entity.TimeSheetProject;
import com.laminatimes.timesheet.repository.TimeSheetProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TimeSheetProjectService {

    @Autowired
    TimeSheetProjectRepository repository;

    public List<TimeSheetProject> get() {
        return repository.findAll();
    }

}
