package com.klef.jfsd.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klef.jfsd.exam.model.Customer;
import com.klef.jfsd.exam.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	    @Autowired
	    private CustomerService customerService;

	    @PutMapping("/")
	    public String updateCustomer(@RequestBody Customer customer) {
	        return customerService.updateCustomer(customer);
	    }

	    @PostMapping("/")
	    public String createCustomer(@RequestBody Customer customer) {
	        return customerService.insertCustomer(customer);
	    }

}
