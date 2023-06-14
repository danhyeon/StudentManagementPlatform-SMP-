package com.codehows.smp.controller;

import com.codehows.smp.dto.SeatDto;
import com.codehows.smp.dto.StudentDto;
import com.codehows.smp.entity.Student;
import com.codehows.smp.service.ClassService;
import com.codehows.smp.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping(value = "/class")
@Controller
@RequiredArgsConstructor
public class ClassManageController {

    private final ClassService classService;
    private final StudentService studentService;

    @GetMapping(value = "/info")
    public String infoManage() {
        return "pages/classManage/classInfo";
    }

    @ResponseBody
    @PostMapping(value = "/seats")
    public Map<String, Object> getSeats() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("dataA", classService.getSeatsList("A반"));
        result.put("dataB",classService.getSeatsList("B반"));
        return result;
    }

    @ResponseBody
    @GetMapping(value = "/detail/{id}")
    public ResponseEntity getDetail(@PathVariable("id")Long id) {
        StudentDto studentDto = studentService.getStudent(id);
        return new ResponseEntity<StudentDto>(studentDto, HttpStatus.OK);
    }
}
