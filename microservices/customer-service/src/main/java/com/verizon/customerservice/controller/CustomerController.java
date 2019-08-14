package com.verizon.customerservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.verizon.customerservice.model.Customer;
import com.verizon.customerservice.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(method=RequestMethod.GET,value= "/all")
	public List<Customer> getAllCustomers() {
		return customerService.getAllCustomers();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public Customer getCustomer(@PathVariable int id) {
		return customerService.getById(id);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/create")
	public Customer createCustomer(@RequestBody String name, String email) {
		return customerService.createCustomer(name, email);
	}
	
}
