package com.lukas.shopsystem.service;

import com.lukas.shopsystem.model.Student;

import java.util.List;

public interface StudentService {
    public Student saveStudent(Student student);

    public List<Student> getAllStudents();
}
