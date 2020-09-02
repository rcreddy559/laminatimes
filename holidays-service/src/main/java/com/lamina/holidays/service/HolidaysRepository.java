package com.lamina.holidays.service;

import com.lamina.holidays.entity.Holiday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HolidaysRepository extends JpaRepository<Holiday, Integer> {
    Optional<List<Holiday>> findByName(String name);
}
