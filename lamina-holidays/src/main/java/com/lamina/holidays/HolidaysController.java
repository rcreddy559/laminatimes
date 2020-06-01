package com.lamina.holidays;

import com.lamina.holidays.entity.Holiday;
import com.lamina.holidays.service.HolidaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@RestController
@RequestMapping("/holidays")
public class HolidaysController {

    @Autowired
    HolidaysService service;

    @GetMapping
    public Set<Holiday> getHolidays() {
        return service.getHolidays();
    }

    @GetMapping("/id/{id}")
    public Holiday getHolidayById(@PathVariable int id) {
    return service.get(id);
    }

    @GetMapping("/name/{name}")
    public Set<Holiday> getHolidayByName(@PathVariable String name) {
        return service.get(name);
    }

    @GetMapping("/year/{year}")
    public Set<Holiday> getHolidayByDates(@PathVariable Integer year) {
        return service.getByYear(year);
    }

}
