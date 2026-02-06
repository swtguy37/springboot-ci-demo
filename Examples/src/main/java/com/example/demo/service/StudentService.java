package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Student;

public interface StudentService {
	
	List<Student> getAllStudents();
	void saveStudent(Student student);
	Student getStudentById(int id);
	Student updateStudent(Student student, int id);
	int deleteStudent(int id);
	

}
