package com.example.StudentManagement.controller;

import com.example.StudentManagement.dto.StudentDto;
import com.example.StudentManagement.dto.TeacherDto;
import com.example.StudentManagement.entity.Student;
import com.example.StudentManagement.entity.Teacher;
import com.example.StudentManagement.service.StudentService;
import com.example.StudentManagement.service.TeacherService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    ModelMapper modelMapper;

    public TeacherController(TeacherService teacherService, ModelMapper modelMapper) {
        this.teacherService = teacherService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/createTeacher")
    public ResponseEntity<TeacherDto> createTeacher(@RequestBody TeacherDto tchDto) {
        // convert DTO to entity

        Teacher tchRequest = modelMapper.map(tchDto, Teacher.class);
        Teacher tch = teacherService.createTeacher(tchRequest);
        // convert entity to DTO
        TeacherDto tchResponse = modelMapper.map(tch, TeacherDto.class);

        return new ResponseEntity<TeacherDto>(tchResponse, HttpStatus.CREATED);
    }

    @GetMapping("/getTeacherById/{id}")
    public ResponseEntity<TeacherDto> getTeacherId(@PathVariable long id) {

        Teacher tch = teacherService.findTeacherById(id);
        // entity to DTO

        TeacherDto tchResponse = modelMapper.map(tch, TeacherDto.class);
        return ResponseEntity.ok().body(tchResponse);
    }

    @GetMapping("/getAllTeachers")
    public List<TeacherDto> getAllTeachers() {
        return teacherService.findAllTeachers().stream().map(emp -> modelMapper.map(emp, TeacherDto.class)).collect(Collectors.toList());
    }

    @PutMapping("/updateTeacherById/{id}")
    public ResponseEntity<TeacherDto> updateTeacherById(@RequestBody TeacherDto tchDto){
        // convert DTO to Entity
        Teacher tchRequest = modelMapper. map(tchDto, Teacher.class);
        Teacher tch = teacherService.updateTeacherById(tchRequest);
        // entity to DTO
        TeacherDto tchResponse = modelMapper.map(tch, TeacherDto.class);
        return ResponseEntity.ok().body(tchResponse);
    }

    @DeleteMapping("/deleteTeacherId/{id}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable long id){
        teacherService.deleteTeacherById(id);
        return ResponseEntity.noContent().build();
    }
}
