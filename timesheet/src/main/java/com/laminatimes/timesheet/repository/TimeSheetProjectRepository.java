package com.laminatimes.timesheet.repository;

import com.laminatimes.timesheet.entity.TimeSheetProject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeSheetProjectRepository extends JpaRepository<TimeSheetProject, Long> {
}
