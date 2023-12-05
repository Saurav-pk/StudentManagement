package com.example.StudentManagement.service.impl;


import com.example.StudentManagement.entity.Student;
import com.example.StudentManagement.repository.StudentRepository;
import com.example.StudentManagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public Student createStudent(Student std){
        return studentRepository.save(std);
    }

    @Override
    public Student findStudentById(long id){
        Student stdFound = studentRepository.findById(id).orElse(null);
        return stdFound;
    }

    @Override
    public List<Student> findAllStudents(){
        return studentRepository.findAll();
    }

    @Override
    public Student updateStudentById(Student std){
        return studentRepository.save(std);
    }

    @Override
    public void deleteStudentById(long id){
        Student stdFound = studentRepository.findById(id).orElse(null);
        studentRepository.deleteById(stdFound.getStudent_Id());

    }












}

