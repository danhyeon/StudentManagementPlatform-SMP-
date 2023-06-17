package com.codehows.smp.dto;

import com.codehows.smp.entity.Seat;
import com.codehows.smp.entity.Student;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.modelmapper.ModelMapper;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class SeatDto {

    private Long seatId;

    private String classAB;

    private Long studentId;

    private String name;

    private static ModelMapper modelMapper = new ModelMapper();
    public static SeatDto of(Seat seat) {
        return modelMapper.map(seat, SeatDto.class);
    }

    public SeatDto(Long studentId, Long seatId, String classAB, String name) {
        this.studentId = studentId;
        this.seatId = seatId;
        this.classAB = classAB;
        this.name = name;
    }

}
