package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.StudentDTO;
import com.example.demo.entity.Student;
import com.example.demo.exception.StudentNtFoundException;
import com.example.demo.exceptions.StudentNotFound;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	
	List<Student> lstStudents = new ArrayList<>( Arrays.asList(new Student(1,"Rock"),new Student(2,"Ravi"),
			new Student(3,"Rock1"),new Student(4,"Ravi1")));

	@Override
	public List<Student> getAllStudents() {
		return lstStudents;
	}

	@Override
	public Student getStudentById(int id) {
		Student std = lstStudents.stream().filter(s->s.getRid()==id).findFirst().
				orElseThrow(()->new StudentNotFound("No Student with id " + id));
		return std;
	}

	@Override
	public int deleteStudent(int id) {
		boolean blnValue = lstStudents.removeIf(s->s.getRid()==id);
		return blnValue? id: 0;
	}

	@Override
	public void saveStudent(Student student) {
		// TODO Auto-generated method stub
		
		lstStudents.add(student);
		
	}

	@Override
	public Student updateStudent(Student student, int id) {
		return lstStudents.stream().filter(s->s.getRid() == id).findFirst().map(p->{
			p.setName(student.getName());
			p.setRid(id);
			return p; 
		}).orElseThrow(() -> new StudentNotFound("Student not found with id " + id));
	}
}
