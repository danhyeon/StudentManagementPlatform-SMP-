package com.codehows.smp.service;

import com.codehows.smp.dto.SeatDto;
import com.codehows.smp.dto.StudentDto;
import com.codehows.smp.dto.StudentImgDto;
import com.codehows.smp.entity.Seat;
import com.codehows.smp.entity.SeatID;
import com.codehows.smp.entity.Student;
import com.codehows.smp.entity.StudentImg;
import com.codehows.smp.repository.SeatRepository;
import com.codehows.smp.repository.StudentImgRepository;
import com.codehows.smp.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityExistsException;
import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ClassService {

    private final StudentRepository studentRepository;
    private final StudentImgRepository studentImgRepository;
    private final SeatRepository seatRepository;

    public List<SeatDto> getSeatsList(String classAB) {
        List<SeatDto> seatDtos = seatRepository.findSeatDtoList(classAB);
        return seatDtos;
    }

    public void addProfileImg(StudentImgDto studentImgDto, Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(EntityExistsException::new);
        StudentImg studentImg = studentImgRepository.findByStudentId(studentId);
        if(studentImg == null) {
            studentImg = new StudentImg();
            studentImg.setOriImgName(studentImgDto.getOriImgName());
            studentImg.setImgUrl(studentImgDto.getImgUrl());
            studentImg.setStudent(student);
            studentImgRepository.save(studentImg);
        }else {
            studentImg.setOriImgName(studentImgDto.getOriImgName());
            studentImg.setImgUrl(studentImgDto.getImgUrl());
            studentImg.setStudent(student);
        }
    }

    public StudentImgDto getProfileImg(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(EntityExistsException::new);
        StudentImg studentImg = studentImgRepository.findByStudentId(studentId);
        StudentImgDto studentImgDto = StudentImgDto.of(studentImg);
        return studentImgDto;
    }

    public void updateSeats(SeatDto[] seatDtos) {
        for(SeatDto s : seatDtos) {
            if(s.getStudentId()!= null) {
                Student student = studentRepository.findById(s.getStudentId())
                        .orElseThrow(EntityExistsException::new);

                if (seatRepository.findByStudentId(s.getStudentId()) != null) {
                    Seat last = seatRepository.findByStudentId(s.getStudentId());
                    seatRepository.delete(last);
                }
                if(seatRepository.findBySeatIdAndClassAB(s.getSeatId(), s.getClassAB())!=null) {
                    Seat last = seatRepository.findBySeatIdAndClassAB(s.getSeatId(), s.getClassAB());
                    seatRepository.delete(last);
                }
                Seat newSeat = Seat.createSeat(s, student);
                seatRepository.save(newSeat);
            }
        }
    }
}
