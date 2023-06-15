package com.codehows.smp.dto;

import com.codehows.smp.entity.StudentImg;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter
@Setter
public class StudentImgDto {
    private Long id;

    private String imgName;

    private String oriImgName;

    private String imgUrl;

    private static ModelMapper modelMapper = new ModelMapper();

    public static StudentImgDto of(StudentImg studentImg) {
        return modelMapper.map(studentImg, StudentImgDto.class);
    }
}
