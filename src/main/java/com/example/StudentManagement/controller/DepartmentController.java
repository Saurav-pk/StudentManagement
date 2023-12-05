package com.example.StudentManagement.controller;


import com.example.StudentManagement.dto.DepartmentDto;
import com.example.StudentManagement.entity.Department;
import com.example.StudentManagement.service.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController

@RequestMapping("department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    private ModelMapper modelMapper;

    public DepartmentController(DepartmentService departmentService, ModelMapper modelMapper) {
        super();
        this.departmentService = departmentService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/createDepartment")
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto dpmDto){
        // convert DTO to entity
       Department dpmRequest = modelMapper.map(dpmDto, Department.class);
       Department dpm = departmentService.createDepartment(dpmRequest);
        // convert entity to DTO
       DepartmentDto dpmResponse = modelMapper.map(dpm, DepartmentDto.class);

       return new ResponseEntity<DepartmentDto>(dpmResponse, HttpStatus.CREATED);
    }

    @PutMapping("/updateDepartmentById")
    public ResponseEntity<DepartmentDto> updateDepartment(@RequestBody DepartmentDto dpmDto){
        // convert DTO to Entity
        Department dpmRequest = modelMapper. map(dpmDto, Department.class);
        Department dpm = departmentService.updateDepartment(dpmRequest);
        // entity to DTO
        DepartmentDto dpmResponse = modelMapper.map(dpm, DepartmentDto.class);
        return ResponseEntity.ok().body(dpmResponse);



    }

    @GetMapping("/getAllDepartment")
    public List<DepartmentDto> getAllDepartment(){

        return departmentService.getAllDepartment().stream().map(dpm -> modelMapper.map(dpm, DepartmentDto.class)).collect(Collectors.toList());
    }


    @GetMapping("/getDepartmentById/{id}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable long id) {

        Department dpm = departmentService.getDepartmentById(id);
        // entity to DTO

        DepartmentDto dpmResponse = modelMapper.map(dpm, DepartmentDto.class);
       return ResponseEntity.ok().body(dpmResponse) ;
    }

    @DeleteMapping("/deleteDepartmentByid/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable long id){
        departmentService.deleteDepartment(id);

        return ResponseEntity.noContent().build();
    }












}
