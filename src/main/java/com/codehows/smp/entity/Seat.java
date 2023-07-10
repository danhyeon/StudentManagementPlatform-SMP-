package com.codehows.smp.entity;

import com.codehows.smp.dto.SeatDto;
import lombok.*;
import javax.persistence.*;

@Entity
@Table(name="seat")
@NoArgsConstructor
@AllArgsConstructor
@IdClass(SeatID.class)
public class Seat extends BaseEntity {
    @Id
    @Column(nullable = false)
    private Long seatId;

    @Id
    @Column(nullable = false)
    private String classAB;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", unique = true)
    private Student student;


    private String name;

    public static Seat createSeat(SeatDto seatDto, Student student) {
        return Seat.builder()
                .seatId(seatDto.getSeatId())
                .classAB(seatDto.getClassAB())
                .student(student)
                .name(seatDto.getName())
                .build();
    }

    @Builder
    public Seat(Long seatId, String classAB, String name, Student student) {
        this.seatId = seatId;
        this.name = name;
        this.classAB = classAB;
        this.student = student;
    }

    public void updateStudent(Student student) {
        this.name = student.getName();
        this.student = student;
    }
}
