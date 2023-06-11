package com.codehows.smp.service;

import com.codehows.smp.dto.StudentDto;
import com.codehows.smp.entity.Student;
import com.codehows.smp.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class StudentService {

    private final StudentRepository studentRepository;

    public void addStudent(StudentDto studentDto) {
        Student student = Student.createStudent(studentDto);
        student.setStatus(true);
        studentRepository.save(student);
    }

    public List<StudentDto> getStudentList() {
        List<StudentDto> studentDtoList = new ArrayList<>();
        for(Student s : studentRepository.findAll()) {
            studentDtoList.add(StudentDto.of(s));
        }
        return studentDtoList;
    }

    public StudentDto getStudent(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(EntityExistsException::new);
        return StudentDto.of(student);
    }

    public void updateStudent(StudentDto studentDto) {
        Student student = studentRepository.findById(studentDto.getId())
                .orElseThrow(EntityExistsException::new);
        student.updateStudent(studentDto);
    }

    public void deleteStudent(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(EntityExistsException::new);
        studentRepository.delete(student);
    }
}
