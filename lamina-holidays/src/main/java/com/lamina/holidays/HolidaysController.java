package com.lamina.holidays;

import com.lamina.holidays.entity.Holiday;
import com.lamina.holidays.service.HolidaysService;
import com.lamina.holidays.util.DBDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/holidays")
public class HolidaysController {

    Logger logger= LoggerFactory.getLogger(HolidaysController.class);

    @Autowired
    HolidaysService service;

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${spring.env.prod: default value }")
    private String defaultValue;

    @Value("This is static value")
    private String staticValue;


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
        logger.info("All holidays");
        logger.info("Application name is applicationName: {}" , applicationName);
        logger.info("Default Value defaultValue: {}",defaultValue);
        logger.info("Static value staticValue: {}",staticValue);
        logger.info(dbDetails.toString());

        return service.getHolidays();
    }

    @GetMapping("/id/{id}")
    public Holiday getHolidayById(@PathVariable int id) {
        logger.info("Holiday by id: {}", id);

        return service.get(id);
    }

    @GetMapping("/name/{name}")
    public List<Holiday> getHolidayByName(@PathVariable String name) {
        logger.info("Holiday by name: {}", name);
        return service.get(name);
    }

    @GetMapping("/year/{year}")
    public List<Holiday> getHolidayByDates(@PathVariable Integer year) {

        logger.info("Holiday by year: {}", year);
        return service.getByYear(year);
    }

    @DeleteMapping("/id/{id}")
    public void delete(@PathVariable int id) {
        logger.info("Delete holiday by id: {}", id);
        service.delete(id); }

    @GetMapping("/sort/name")
    public List<Holiday> sortByName() { logger.info("get sorted holiday by name"); return service.sortByName(); }

    @GetMapping("/sort/year")
    public List<Holiday> sortByYear() {logger.info("get sorted holiday by year"); return service.sortByYear(); }
}
