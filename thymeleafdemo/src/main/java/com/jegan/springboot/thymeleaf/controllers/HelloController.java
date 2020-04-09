package com.jegan.springboot.thymeleaf.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jegan.springboot.thymeleaf.model.Student;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	@RequestMapping("/sendData")
	public ModelAndView sendData() {
		ModelAndView mav = new ModelAndView("data");
		mav.addObject("message", "Be the change you want to see!!");
		return mav;
	}
	
	@RequestMapping("/student")
	public ModelAndView getStudent() {
		ModelAndView modelAndView = new ModelAndView("student");
		Student student = new Student();
		student.setName("John");
		student.setScore(100);
		modelAndView.addObject("student", student);
		return modelAndView;
	}
	
	@RequestMapping("/students")
	public ModelAndView getStudents() {
		ModelAndView modelAndView = new ModelAndView("studentList");
		Student student1 = new Student();
		student1.setName("John");
		student1.setScore(100);
		
		Student student2 = new Student();
		student2.setName("Bob");
		student2.setScore(90);
		
		List<Student> students = Arrays.asList(student1, student2);
		
		modelAndView.addObject("students", students);
		return modelAndView;
	}
	
	@RequestMapping("/studentForm")
	public ModelAndView displayStudentForm() {
		ModelAndView modelAndView = new ModelAndView("studentForm");
		Student student = new Student();
		student.setName("John");
		student.setScore(100);
		modelAndView.addObject("student", student);
		return modelAndView;
	}
	
	@RequestMapping("/saveStudent")
	public ModelAndView saveStudnet(@ModelAttribute Student student) {
		ModelAndView modelAndView = new ModelAndView("result");
		modelAndView.addObject("student", student);
		System.out.println(student.getName());
		System.out.println(student.getScore());
		return modelAndView;
	}
}
