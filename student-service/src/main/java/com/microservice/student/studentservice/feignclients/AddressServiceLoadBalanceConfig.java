package com.microservice.student.studentservice.feignclients;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;

import feign.Feign;

@LoadBalancerClient(value="address-service")
public class AddressServiceLoadBalanceConfig {

	public Feign.Builder feignBuilder(){
		return Feign.builder();
	}
}
