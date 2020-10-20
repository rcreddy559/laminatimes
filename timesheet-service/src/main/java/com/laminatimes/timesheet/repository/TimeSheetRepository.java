package com.laminatimes.timesheet.repository;

import com.laminatimes.timesheet.entity.TimeSheet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeSheetRepository extends JpaRepository<TimeSheet, Long> {
}
