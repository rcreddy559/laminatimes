package com.lamina.holidays;

import com.lamina.holidays.entity.Holiday;
import com.lamina.holidays.service.HolidaysService;
import com.lamina.holidays.util.DBDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/holidays")
public class HolidaysController {

    @Autowired
    HolidaysService service;

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${spring.env.prod: default value }")
    private String defaultValue;

    @Value("This is static value")
    private String staticValue;

    @Value("#{${sping.map.dbvalues}}")
    private Map<String, String> dbValues;

    @Autowired
    private DBDetails dbDetails;


    @PostMapping
    public Holiday create(@RequestBody Holiday holiday) {
        return service.save(holiday);
    }

    @PutMapping
    public Holiday update(@RequestBody Holiday holiday) {
        return service.save(holiday);
    }

    @GetMapping
    public List<Holiday> getHolidays() {
        System.out.println("applicationName: "+applicationName);
        System.out.println("defaultValue: "+defaultValue);
        System.out.println("staticValue: "+staticValue);
        System.out.println("dbValues:"+dbValues);
        System.out.println(dbDetails.toString());

        return service.getHolidays();
    }

    @GetMapping("/id/{id}")
    public Holiday getHolidayById(@PathVariable int id) {
        return service.get(id);
    }

    @GetMapping("/name/{name}")
    public List<Holiday> getHolidayByName(@PathVariable String name) {
        return service.get(name);
    }

    @GetMapping("/year/{year}")
    public List<Holiday> getHolidayByDates(@PathVariable Integer year) {
        return service.getByYear(year);
    }

    @DeleteMapping("/id/{id}")
    public void delete(@PathVariable int id) { service.delete(id); }

    @GetMapping("/sort/name")
    public List<Holiday> sortByName() { return service.sortByName(); }

    @GetMapping("/sort/year")
    public List<Holiday> sortByYear() { return service.sortByYear(); }
}
