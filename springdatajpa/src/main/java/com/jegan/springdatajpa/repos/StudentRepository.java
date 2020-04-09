package com.jegan.springdatajpa.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jegan.springdatajpa.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
