package com.example.StudentManagement.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "teacher")
public class Teacher {
    @Id
    private long teacher_Id;
    private String teacher_Name;
    private String phone;
    private String address;

    @ManyToOne
    @JoinColumn(name = "department_Id", nullable = false, referencedColumnName = "department_Id")
    @JsonBackReference
    private Department department;

}
