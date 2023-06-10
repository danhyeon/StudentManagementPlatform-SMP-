package com.codehows.smp.controller;

import com.codehows.smp.dto.StudentDto;
import com.codehows.smp.entity.Student;
import com.codehows.smp.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping(value = "/student")
@Controller
@RequiredArgsConstructor
public class StudentManageController {

    private final StudentService studentService;

    @GetMapping(value = "/info")
    public String infoManage(Model model) {
        List<StudentDto> studentDtoList = new ArrayList<>();
        for(Student s : studentService.getStudentList()) {
            studentDtoList.add(StudentDto.of(s));
        }
        model.addAttribute("studentDtoList", studentDtoList);
        return "pages/studentManage/studentInfo";
    }

    @ResponseBody
    @PostMapping(value = "/info")
    public ResponseEntity addStudent(@RequestBody StudentDto studentDto) {

//        if(bindingResult.hasErrors()) {
//            StringBuilder sb = new StringBuilder();
//            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
//            for(FieldError fieldError : fieldErrors) {
//                sb.append(fieldError.getDefaultMessage());
//            }
//            return new ResponseEntity<String>(sb.toString(), HttpStatus.BAD_REQUEST);
//        }
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            studentService.addStudent(Student.createStudent(studentDto));
            map.put("result", "ok");
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<Object>(map, HttpStatus.OK);
    }
}
