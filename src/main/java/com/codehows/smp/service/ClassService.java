package com.codehows.smp.service;

import com.codehows.smp.dto.SeatDto;
import com.codehows.smp.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ClassService {

    private final StudentRepository studentRepository;

    public List<SeatDto> getSeatsList(String classAB) {
        return studentRepository.findSeatDtoList(classAB);
    }

}
