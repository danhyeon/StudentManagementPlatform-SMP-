package com.codehows.smp.repository;

import com.codehows.smp.dto.SeatDto;
import com.codehows.smp.dto.StudentDto;
import com.codehows.smp.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("select new com.codehows.smp.dto.SeatDto(s.id, s.name, s.seat) " +
            "from Student s " +
            "where s.classAB = :classAB " +
            "order by s.seat asc")
    List<SeatDto> findSeatDtoList(String classAB);

    List<Student> findByClassAB(String classAB);
}
