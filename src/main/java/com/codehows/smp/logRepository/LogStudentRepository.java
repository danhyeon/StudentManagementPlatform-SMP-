package com.codehows.smp.logRepository;

import com.codehows.smp.entity.Student;
import com.codehows.smp.logEntity.LogStudent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogStudentRepository extends JpaRepository<LogStudent, Long> {
}
