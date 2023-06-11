package com.codehows.smp.dto;

import com.codehows.smp.entity.Student;
import lombok.*;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class StudentDto {

    private Long id;

    private String name;

    private String birth;

    private String phone;

    private String classAB;

    private String residence;

    private String belong;

    private String major;

    private String graduate;

    private String email;

    private LocalDate start;

    private Boolean status;

    private String note;

    private static ModelMapper modelMapper = new ModelMapper();

    public static StudentDto of(Student student) {
        return modelMapper.map(student, StudentDto.class);
    }
}
