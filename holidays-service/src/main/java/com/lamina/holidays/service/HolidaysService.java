package com.lamina.holidays.service;

import com.lamina.holidays.entity.Holiday;
import com.lamina.holidays.exception.HolidaysNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HolidaysService {

    @Autowired
    HolidaysRepository repository;

    public Holiday save(Holiday holiday) {
        return repository.save(holiday);
    }

    public List<Holiday> getHolidays() {
        return repository.findAll();
    }

    public Holiday get(int id) {
        return repository.findById(id).orElseThrow(() -> new HolidaysNotFoundException("No Holiday with name: " + id));
    }

    public List<Holiday> get(String name) {
        System.out.println(repository.findByName(name));
        return repository.findByName(name)
                .orElseThrow(() -> new HolidaysNotFoundException("No Holiday with name: " + name));
    }

    public List<Holiday> getByYear(int year) {
        return repository.findAll().stream()
                .filter(holiday -> holiday.getStartDate().getYear() == year).collect(Collectors.toList());
    }


    public void delete(int id) {
        repository.delete(repository.findById(id)
                .orElseThrow(() -> new HolidaysNotFoundException("No holiday with id:" + id)));
    }

    public List<Holiday> sortByName() {
        return repository.findAll().stream().sorted(Comparator.comparing(Holiday::getName)).collect(Collectors.toList());
    }

    public List<Holiday> sortByYear() {
        return repository.findAll().stream().sorted(Comparator.comparing(Holiday::getStartDate)).collect(Collectors.toList());
    }
}

class HolidaysComparator implements Comparator<Holiday> {

    @Override
    public int compare(Holiday o1, Holiday o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

//protobuf
