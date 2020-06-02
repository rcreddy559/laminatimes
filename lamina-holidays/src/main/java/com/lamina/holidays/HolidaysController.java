package com.lamina.holidays;

import com.lamina.holidays.entity.Holiday;
import com.lamina.holidays.service.HolidaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping()
    public Holiday create(@RequestBody Holiday holiday) {
        return service.create(holiday);
    }

    @PutMapping
    public Holiday update(@RequestBody Holiday holiday) {
        return service.update(holiday);
    }

    @DeleteMapping("/id/{id}")
    public Holiday delete(@PathVariable int id) throws Exception {
        return service.delete(id);
    }

}
