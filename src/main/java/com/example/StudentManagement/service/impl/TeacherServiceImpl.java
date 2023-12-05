package com.example.StudentManagement.service.impl;

import com.example.StudentManagement.entity.Teacher;
import com.example.StudentManagement.repository.TeacherRepository;
import com.example.StudentManagement.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository){
        this.teacherRepository = teacherRepository;
    }

    @Override
    public Teacher createTeacher(Teacher tch){
        return teacherRepository.save(tch);
    }

    @Override
    public Teacher findTeacherById(long id){
        Teacher tchFound = teacherRepository.findById(id).orElse(null);
        return tchFound;
    }

    @Override
    public List<Teacher> findAllTeachers(){
        return teacherRepository.findAll();
    }

    @Override
    public Teacher updateTeacherById(Teacher tch){
        return teacherRepository.save(tch);
    }

    @Override
    public void deleteTeacherById(long id){
        Teacher tchFound = teacherRepository.findById(id).orElse(null);
        teacherRepository.deleteById(tchFound.getTeacher_Id());

    }
}
