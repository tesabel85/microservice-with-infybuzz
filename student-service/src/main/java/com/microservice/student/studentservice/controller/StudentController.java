package com.microservice.student.studentservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.student.studentservice.entity.Student;
import com.microservice.student.studentservice.response.StudentResponse;
import com.microservice.student.studentservice.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {

	@Autowired
	private StudentService studentSerice;
	
	@GetMapping("/")
	public List<Student> allStudent(){
		return studentSerice.allStudent();
	}
	
	@PostMapping("/service")
	public StudentResponse saveOrUpdate(@RequestBody StudentResponse std) {
		return studentSerice.saveOrUpdate(std);
	}
	
	@GetMapping("/service/{id}")
	public StudentResponse getById(@PathVariable long id) {
		return studentSerice.getById(id);
	}
	
	@DeleteMapping("/service/{id}")
	public StudentResponse deleteById(@PathVariable long id) {
		return studentSerice.deleteById(id);
	}
}
