package com.codehows.smp.dto;

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

    private Long id;

    private String name;

    private Integer seat;

    private static ModelMapper modelMapper = new ModelMapper();

    public static SeatDto of(Student student) {
        return modelMapper.map(student, SeatDto.class);
    }

    public SeatDto(Long id, String name, Integer seat) {
        this.id = id;
        this.name = name;
        this.seat = seat;
    }

}
