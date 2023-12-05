package com.example.StudentManagement.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDto {
    private long teacher_Id;
    @NotEmpty
    @Size(min = 2, message = "Student name should have at least 2 characters")
    private String teacher_Name;
    @NotEmpty
    private String phone;
    @NotEmpty
    private String address;
    @NotEmpty
    private long department_Id;

    private String department_Name;
}
