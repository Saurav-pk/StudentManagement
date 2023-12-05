package com.example.StudentManagement.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "student")
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    private long student_Id;
    private String student_Name;
    private String phone;
    private String address;

    @ManyToOne
    @JoinColumn(name = "department_Id", nullable = false, referencedColumnName = "department_Id")
    @JsonBackReference
    private Department department;
}
