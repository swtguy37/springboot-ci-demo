package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.Student;

public interface StudentRepository {
	
	List<Student> getAllStudents();
	Student saveStudent(Student student);
	Student getStudentById(int id);
	Student updateStudent(Student student, int id);
	int deleteStudent(int id);
	

}
