package com.codehows.smp.repository;

import com.codehows.smp.dto.StudentDto;
import com.codehows.smp.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
