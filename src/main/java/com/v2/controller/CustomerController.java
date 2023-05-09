package com.v2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.v2.model.Customer;
import com.v2.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	

	@GetMapping(value = "/getCust0mer")
	public List<Customer> getCustomer() {
		return  customerService.getCustomers();
	}

	@PostMapping(value = "/saveCustmer")
	public Customer saveCustomer(@RequestBody Customer cust) {
		return customerService.saveCust(cust);
	}
	
	//Mgs Published to Kafka Topic
	@PostMapping(value = "/addCustmer")
	public String addCustomer(@RequestBody List<Customer> cust) {
		return customerService.add(cust);
	}

}
