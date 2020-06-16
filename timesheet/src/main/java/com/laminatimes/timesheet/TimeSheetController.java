package com.laminatimes.timesheet;

import com.laminatimes.timesheet.entity.*;
import com.laminatimes.timesheet.exception.TimeSheetException;
import com.laminatimes.timesheet.service.TimeSheetProjectService;
import com.laminatimes.timesheet.service.TimeSheetService;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/timesheet")
public class TimeSheetController {

    final String PROJECT_URL = "http://projects/projects/";

    @Autowired
    private TimeSheetService service;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Autowired
    private TimeSheetProjectService timeSheetProjectService;

    @GetMapping
    public List<TimeSheetEntity> getAll() {
        List<TimeSheetEntity> entities = service.getAll();
         return entities.stream().map(e->{
            e.setTimeSheetProjects(e.getTimeSheetProjects().stream().map(p->{
                Project ptemp = getProject(p.getProjectId());
                p.setDescription(ptemp.getDescription());
                p.setName(ptemp.getName());
                return p;
            }).collect(Collectors.toList()));
            return e;
        }).collect(Collectors.toList());
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
        List<TimeSheetProjectEntity> projects = timeSheetEntity.getTimeSheetProjects();
        projects.forEach(entity -> getProject(entity.getProjectId()));

    }

    private Project getProject(Long id) {
        try {
            return restTemplate.getForObject(PROJECT_URL+id, Project.class);
        } catch (Exception e) {
            throw new TimeSheetException("No Project found with id:"+id);
        }
    }
}
