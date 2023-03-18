package com.microservice.address.addressservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.address.addressservice.entity.Address;
import com.microservice.address.addressservice.request.AddressRequest;
import com.microservice.address.addressservice.response.AddressResponse;
import com.microservice.address.addressservice.service.AddressService;

@RestController
@RequestMapping("/api/address")
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	@GetMapping("/")
	public List<Address> allAddress(){
		return addressService.allAddress();
	}
	
	@PostMapping("/service")
	public AddressResponse saveOrUpdate(@RequestBody AddressRequest addressRequest) {
		return addressService.saveOrUpdate(addressRequest);
	}
	
	@GetMapping("/service/{id}")
	public AddressResponse getAddressById(@PathVariable long id) {
		return addressService.getById(id);
	}
	
	@DeleteMapping("/service/{id}")
	public AddressResponse deleteById(@PathVariable long id) {
		return addressService.deleteById(id);
	}

}
