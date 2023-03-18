package com.microservice.student.studentservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.web.reactive.function.client.WebClient;

import com.microservice.student.studentservice.entity.Student;
import com.microservice.student.studentservice.feignclients.AddressFeignClient;
import com.microservice.student.studentservice.repository.StudentRepository;
import com.microservice.student.studentservice.response.AddressResponse;
import com.microservice.student.studentservice.response.StudentResponse;

import reactor.core.publisher.Mono;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
//	@Autowired
//	WebClient webClient;
	
	@Autowired
	AddressFeignClient addressFeign;
	
	public List<Student> allStudent(){
		return studentRepository.findAll();
	}
	
	public StudentResponse saveOrUpdate(StudentResponse stdResponse) {
		Student std = new Student();
		if(0 !=stdResponse.getStudentId()) {
			std.setStudentId(stdResponse.getStudentId());
		}
		std.setFirstName(stdResponse.getFirstName());
		std.setLastName(stdResponse.getLastName());
		std.setAddressId(stdResponse.getAddressId());
		
		studentRepository.save(std);
		
		StudentResponse stdRes = new StudentResponse(std);
		
		stdRes.setAddressResponse(addressFeign.getAddressById(std.getAddressId()));
		
		return stdRes;
	}
	
	public StudentResponse getById(long stdId) {
		Student std = studentRepository.getOne(stdId);
		StudentResponse stdRes = new StudentResponse(std);
		stdRes.setAddressResponse(addressFeign.getAddressById(std.getAddressId()));
		return stdRes;
	}
	
	public StudentResponse deleteById(long stdId) {
		studentRepository.deleteById(stdId);
		return new StudentResponse();
	}
	
	//call address from address-service by addressId
//	public AddressResponse getAddressByIdUsingWebClient(long addId) {
//		Mono<AddressResponse> addResponse = 
//				webClient.get().uri("/service/"+addId).retrieve().bodyToMono(AddressResponse.class);
//		
//		return addResponse.block();
//	}
}
