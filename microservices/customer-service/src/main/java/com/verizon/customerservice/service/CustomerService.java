package com.verizon.customerservice.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.verizon.customerservice.model.Customer;


@Service
public class CustomerService {
	
	private List<Customer> customers = new ArrayList<>();
	
	@PostConstruct
	public void setup() {
		customers.add(new Customer(101,"Sundeep","Hyderabad"));
		customers.add(new Customer(102,"Rajesh","Mumbai"));
		customers.add(new Customer(103,"Navdeep","Chennai"));
		customers.add(new Customer(104,"Dijoy","Kolkata"));
	}
	
	public List<Customer> getAllCustomers(){
		return customers;
	}

	public Customer getById(int id) {
		return customers.stream().filter(cust -> cust.getId() == id).findAny().orElse(null);
	}

	public Customer createCustomer(String name, String email) {
		int randomId = (int)(Math.random() * 100);
		Customer newCustomer = new Customer(randomId, name, email);
		return newCustomer;
	}
	
	
}
