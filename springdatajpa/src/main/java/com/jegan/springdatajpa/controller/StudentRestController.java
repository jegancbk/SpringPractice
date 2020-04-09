package com.jegan.springdatajpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jegan.springdatajpa.entities.Student;
import com.jegan.springdatajpa.repos.StudentRepository;


@RestController
public class StudentRestController {
	

	@Autowired
	StudentRepository repository;
	
	@RequestMapping(value="/students", method=RequestMethod.GET)
	public List<Student> getProducts() {
		return repository.findAll();		
	}
	
	@RequestMapping(value="/students/{id}", method=RequestMethod.GET)
	public Student getStudent(@PathVariable("id") int id) {
		return repository.findById(id).get();
	}
	
	@RequestMapping(value="/students", method=RequestMethod.POST)
	public Student createStudent(@RequestBody Student student) {
		return repository.save(student);
	}
	
	@RequestMapping(value="/students", method=RequestMethod.PUT)
	public Student updateStudent(@RequestBody Student student) {
		return repository.save(student);
	}
	
	@RequestMapping(value="/students/{id}", method=RequestMethod.DELETE)
	public void deleteStudent(@PathVariable("id") int id) {
		repository.deleteById(id);
	}

}
