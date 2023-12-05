package com.example.StudentManagement.service;

import com.example.StudentManagement.entity.Teacher;

import java.util.List;

public interface TeacherService {
    Teacher createTeacher(Teacher tch);

    Teacher findTeacherById(long id);

    List<Teacher> findAllTeachers();

    Teacher updateTeacherById(Teacher tch);

    void deleteTeacherById(long id);
}
