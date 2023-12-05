package com.example.StudentManagement.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class StudentDto {
    private long student_Id;
    @NotEmpty
    @Size(min = 2, message = "Student name should have at least 2 characters")
    private String student_Name;
    @NotEmpty
    private String phone;
    @NotEmpty
    private String address;
    @NotEmpty
    private long department_Id;

    private String department_Name;


}
