package com.microservice.address.addressservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.address.addressservice.entity.Address;
import com.microservice.address.addressservice.repository.AddressRepository;
import com.microservice.address.addressservice.request.AddressRequest;
import com.microservice.address.addressservice.response.AddressResponse;

@Service
public class AddressService {

	@Autowired
	private AddressRepository addressRepository;
	
	public List<Address> allAddress(){
		return addressRepository.findAll();
	}
	
	public AddressResponse saveOrUpdate(AddressRequest adressReq) {
		Address address = new Address();
		if(null!=adressReq.getAddressId() && adressReq.getAddressId() !=0) {
			address.setAddressId(adressReq.getAddressId());
		}
		address.setStreet(adressReq.getStreet());
		address.setCity(adressReq.getCity());
		address.setState(adressReq.getState());
		address.setZip(adressReq.getZip());
		
		addressRepository.save(address);
		
		return new AddressResponse(address);
	}
	public AddressResponse getById(long addId) {
		return new AddressResponse(addressRepository.getOne(addId));
	}
	public AddressResponse deleteById(long addId) {
		addressRepository.deleteById(addId);
		return new AddressResponse();
	}
}
