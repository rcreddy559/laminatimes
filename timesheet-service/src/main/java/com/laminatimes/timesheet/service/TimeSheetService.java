package com.laminatimes.timesheet.service;

import com.laminatimes.timesheet.entity.TimeSheet;
import com.laminatimes.timesheet.entity.TimeSheetEntity;
import com.laminatimes.timesheet.entity.TimeSheetProject;
import com.laminatimes.timesheet.entity.TimeSheetProjectEntity;
import com.laminatimes.timesheet.exception.TimeSheetException;
import com.laminatimes.timesheet.repository.TimeSheetRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TimeSheetService {

    @Autowired
    private TimeSheetRepository repository;

    public List<TimeSheetEntity> getAll() {
        return copyTimeSheet(repository.findAll());
    }

    public TimeSheet get(Long id) {
        return repository.findById(id).orElseThrow(()->
                new TimeSheetException("No time sheet with id: "+ id));
    }

    public void create(TimeSheetEntity timeSheetEntity) {
        TimeSheet timeSheet = copyTimeSheet(timeSheetEntity);
        repository.save(timeSheet);
    }

    public static TimeSheet copyTimeSheet(TimeSheetEntity timeSheetEntity) {
        TimeSheet timeSheet = new TimeSheet();
        BeanUtils.copyProperties(timeSheetEntity, timeSheet);

        List<TimeSheetProject> projects = new ArrayList<>(timeSheetEntity.getTimeSheetProjects().size());

        timeSheetEntity.getTimeSheetProjects().forEach(entity -> {
            TimeSheetProject tpe = new TimeSheetProject();
            BeanUtils.copyProperties(entity, tpe);
            projects.add(tpe);
        });

        timeSheet.setTimeSheetProjects(projects);
        return timeSheet;
    }

    public static TimeSheetEntity copyTimeSheet(TimeSheet timeSheet) {
        TimeSheetEntity  timeSheetEntity = new TimeSheetEntity();
        BeanUtils.copyProperties(timeSheet, timeSheetEntity);

        List<TimeSheetProjectEntity> projects = new ArrayList<>(timeSheet.getTimeSheetProjects().size());

        timeSheet.getTimeSheetProjects().forEach(entity -> {
            TimeSheetProjectEntity tpe = new TimeSheetProjectEntity();
            BeanUtils.copyProperties(entity, tpe);
            projects.add(tpe);
        });

        timeSheetEntity.setTimeSheetProjects(projects);
        return timeSheetEntity;
    }

    protected static List<TimeSheetEntity> copyTimeSheet(List<TimeSheet> timeSheets) {
        List<TimeSheetEntity> timeSheetEntities = new ArrayList<>(timeSheets.size());
        timeSheets.forEach(timeSheet->{
            TimeSheetEntity entity = new TimeSheetEntity();
            BeanUtils.copyProperties(copyTimeSheet(timeSheet),entity);
            timeSheetEntities.add(entity);
        });
        return timeSheetEntities;
    }
}
