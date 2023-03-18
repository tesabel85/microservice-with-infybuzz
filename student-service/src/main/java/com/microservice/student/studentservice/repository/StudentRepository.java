package com.microservice.student.studentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.student.studentservice.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}
