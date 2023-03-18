package com.microservice.student.studentservice.response;

import com.microservice.student.studentservice.entity.Student;

public class StudentResponse {
	private long studentId;
	private String firstName;
	private String lastName;
	private long addressId;
	private AddressResponse addressResponse;
	public StudentResponse() {}
	public StudentResponse(Student std) {
		this.studentId = std.getStudentId();
		this.firstName = std.getFirstName();
		this.lastName = std.getLastName();
		this.addressId = std.getAddressId();
	}
	public long getStudentId() {
		return studentId;
	}
	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public long getAddressId() {
		return addressId;
	}
	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}
	public AddressResponse getAddressResponse() {
		return addressResponse;
	}
	public void setAddressResponse(AddressResponse addressResponse) {
		this.addressResponse = addressResponse;
	}
	
}
