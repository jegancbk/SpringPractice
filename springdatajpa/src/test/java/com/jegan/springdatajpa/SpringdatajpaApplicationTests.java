package com.jegan.springdatajpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jegan.springdatajpa.entities.Student;
import com.jegan.springdatajpa.repos.StudentRepository;

import static org.junit.Assert.*;


@SpringBootTest
class SpringdatajpaApplicationTests {

	@Autowired
	private StudentRepository repository;
	@Test
	void testSaveStudent() {
		Student student = new Student();
		student.setId(1);
		student.setName("Jegan");
		student.setTestScore(100);
		repository.save(student);
		
		Student savedStudent = repository.findById(1).get();
		assertNotNull(savedStudent);
	}
	
	@Test
	void testReadStudent() {
		Student student = new Student();
		student.setId(1);
		student.setName("Jegan");
		student.setTestScore(100);
		repository.save(student);
		
		Student savedStudent = repository.findById(1).get();
		assertEquals("Jegan", savedStudent.getName());
		
	}
	
	@Test
	void testUpdateStudent() {
		Student student = new Student();
		student.setId(1);
		student.setName("Jegan");
		student.setTestScore(100);
		repository.save(student);
		
		Student savedStudent = repository.findById(1).get();
		
		savedStudent.setTestScore(99);
		assertEquals(99, savedStudent.getTestScore());
	}
	
	@Test
	void testDeleteStudent() {
		Student student = new Student();
		student.setId(1);
		student.setName("Jegan");
		student.setTestScore(100);
		repository.save(student);
		
		repository.deleteById(1);
		assertEquals(0, repository.count());
	}

}
