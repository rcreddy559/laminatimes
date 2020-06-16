package com.laminatimes.timesheet;

import com.laminatimes.timesheet.entity.TimeSheet;
import com.laminatimes.timesheet.entity.TimeSheetEntity;
import com.laminatimes.timesheet.entity.TimeSheetProject;
import com.laminatimes.timesheet.entity.TimeSheetProjectEntity;
import com.laminatimes.timesheet.service.TimeSheetProjectService;
import com.laminatimes.timesheet.service.TimeSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/timesheet")
public class TimeSheetController {

    @Autowired
    private TimeSheetService service;

    @Autowired
    private RestTemplate template;

    @Autowired
    private TimeSheetProjectService timeSheetProjectService;

    @GetMapping
    public List<TimeSheetEntity> getAll() {
        return service.getAll();
    }

    @PostMapping
    @PutMapping
    public ResponseEntity create(@RequestBody TimeSheetEntity timeSheetEntity) {
        System.out.println("==========================================");
        System.out.println(timeSheetEntity.toString());
        System.out.println("==========================================");
        validateTimeSheetEntity(timeSheetEntity);
        service.create(timeSheetEntity);
        return new ResponseEntity(HttpStatus.OK);
    }

    private void validateTimeSheetEntity(TimeSheetEntity timeSheetEntity) {

    }

    private void validateUser(Long userId) {

    }
}
