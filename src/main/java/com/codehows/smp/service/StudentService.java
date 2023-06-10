package com.codehows.smp.service;

import com.codehows.smp.dto.StudentDto;
import com.codehows.smp.entity.Student;
import com.codehows.smp.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class StudentService {

    private final StudentRepository studentRepository;

    public void addStudent(Student student) {
        student.setStatus(true);
        studentRepository.save(student);
    }

    public List<Student> getStudentList() {
        return studentRepository.findAll();
    }

}
