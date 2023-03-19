package com.microservice.student.studentservice.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.microservice.student.studentservice.response.AddressResponse;


//@FeignClient(url="${address.service.url}", value="address-feign-client", path="/api/address")
@FeignClient( value="address-service", path="/api/address")
public interface AddressFeignClient {
	
//	@PostMapping("/service")
//	public AddressResponse saveOrUpdate(@RequestBody AddressResponse addressRequest) ;
	
	@GetMapping("/service/{id}")
	public AddressResponse getAddressById(@PathVariable(value="id") long id);
	
//	@DeleteMapping("/service/{id}")
//	public AddressResponse deleteById(@PathVariable long id) ;
	
}
