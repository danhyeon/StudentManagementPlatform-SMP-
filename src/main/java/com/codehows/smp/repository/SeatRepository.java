package com.codehows.smp.repository;

import com.codehows.smp.dto.SeatDto;
import com.codehows.smp.entity.Seat;
import com.codehows.smp.entity.SeatID;
import com.codehows.smp.entity.Student;
import com.codehows.smp.entity.StudentImg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SeatRepository extends JpaRepository<Seat, SeatID> {

    @Query("select new com.codehows.smp.dto.SeatDto(s.student.id, s.seatId, s.classAB, s.name) " +
            "from Seat s " +
            "where s.classAB = :classAB " +
            "order by s.seatId asc")
    List<SeatDto> findSeatDtoList(String classAB);

    @Query("select s from Seat s where s.student.id = :studentId")
    Seat findByStudentId(@Param("studentId")Long studentId);

    Seat findBySeatIdAndClassAB(Long seatId, String classAB);

}
