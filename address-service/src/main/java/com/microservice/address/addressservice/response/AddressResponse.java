package com.microservice.address.addressservice.response;

import com.microservice.address.addressservice.entity.Address;

public class AddressResponse {

	private Long addressId;
	private String street;
	private String city;
	private String state;
	private String zip;
	
	public AddressResponse() {}
	public AddressResponse(Address address) {
		this.addressId = address.getAddressId();
		this.street = address.getStreet();
		this.city = address.getCity();
		this.state = address.getState();
		this.zip = address.getZip();
	}
	public Long getAddressId() {
		return addressId;
	}
	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	
}
