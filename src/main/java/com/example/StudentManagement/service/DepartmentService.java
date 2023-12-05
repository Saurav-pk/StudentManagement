package com.example.StudentManagement.service;


import com.example.StudentManagement.entity.Department;

import java.util.List;

public interface DepartmentService {

    Department getDepartmentById(long id);


    List<Department> getAllDepartment();

    Department createDepartment(Department dpm);

    Department updateDepartment(Department dpm);

    void deleteDepartment(long id);
}
