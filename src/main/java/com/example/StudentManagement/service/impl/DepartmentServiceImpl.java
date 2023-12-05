package com.example.StudentManagement.service.impl;


import com.example.StudentManagement.entity.Department;
import com.example.StudentManagement.repository.DepartmentRepository;
import com.example.StudentManagement.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }



    @Override
    public Department createDepartment(Department dpm){
          return departmentRepository.save(dpm);
    }


    @Override
    public Department getDepartmentById(long departmentId) {
      Department dpmFound = departmentRepository.findById(departmentId).orElse(null);
        return dpmFound;
    }

    @Override
    public List<Department> getAllDepartment(){
        return departmentRepository.findAll();
    }

    @Override
    public Department updateDepartment(Department dpm){


    return departmentRepository.save(dpm);
    }

    @Override
    public void deleteDepartment(long id){
        Department dpmFound = departmentRepository.findById(id).orElse(null);
        assert dpmFound != null;
        departmentRepository.deleteById(dpmFound.getDepartment_Id());
    }

}
