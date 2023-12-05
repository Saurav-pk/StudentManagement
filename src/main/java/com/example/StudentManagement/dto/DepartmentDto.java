package com.example.StudentManagement.dto;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class DepartmentDto {
    private long department_Id;
    @NotEmpty
    @Size(min = 8, message = "department name should have at least 2 characters")
    private String department_Name;
}
