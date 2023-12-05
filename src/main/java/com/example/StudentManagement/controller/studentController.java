package com.example.StudentManagement.controller;


import com.example.StudentManagement.dto.StudentDto;
import com.example.StudentManagement.entity.Student;
import com.example.StudentManagement.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController

@RequestMapping("student")
public class studentController {
    @Autowired
    private StudentService studentService;

     ModelMapper modelMapper;

    public studentController(StudentService studentService, ModelMapper modelMapper) {
        this.studentService = studentService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/createStudent")
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto stdDto) {
        // convert DTO to entity
        Student stdRequest = modelMapper.map(stdDto, Student.class);
        Student std = studentService.createStudent(stdRequest);
        // convert entity to DTO
        StudentDto stdResponse = modelMapper.map(std, StudentDto.class);

        return new ResponseEntity<StudentDto>(stdResponse, HttpStatus.CREATED);
    }

    @GetMapping("/getStudentById/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable long id) {

        Student std = studentService.findStudentById(id);
        // entity to DTO

        StudentDto stdResponse = modelMapper.map(std, StudentDto.class);
        return ResponseEntity.ok().body(stdResponse);
    }

    @GetMapping("/getAllStudents")
    public List<StudentDto> getAllStudents() {
        return studentService.findAllStudents().stream().map(emp -> modelMapper.map(emp, StudentDto.class)).collect(Collectors.toList());
    }

    @PutMapping("/updateStudentById/{id}")
    public ResponseEntity<StudentDto> updateStudentById(@RequestBody StudentDto stdDto){
        // convert DTO to Entity
        Student stdRequest = modelMapper. map(stdDto, Student.class);
        Student std = studentService.updateStudentById(stdRequest);
        // entity to DTO
        StudentDto stdResponse = modelMapper.map(std, StudentDto.class);
        return ResponseEntity.ok().body(stdResponse);
    }

    @DeleteMapping("/deleteStudentId/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable long id){
        studentService.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }


}
