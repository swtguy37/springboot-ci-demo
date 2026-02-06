package com.example.demo;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
import com.example.demo.service.StudentServiceImpl;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class ExamplesApplicationTests {

	
	@Mock
	StudentRepository repository;
	
	@InjectMocks
	StudentServiceImpl serviceImpl;
	
	@Test
	void getStudent() {
		
		Student student = new Student(1,"Ravi");
		
		when(repository.getStudentById(1)).thenReturn(student);
		
		String strName = student.getName();
	
	}

}
