package com.example.StudentManagement.service;

import com.example.StudentManagement.entity.Student;

import java.util.List;

public interface StudentService {
     Student createStudent(Student emp);
     Student findStudentById(long id);
     List<Student> findAllStudents();
     Student updateStudentById(Student emp);

     void deleteStudentById(long id);
}
