package com.klef.jfsd.exam.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.exam.model.Customer;
import com.klef.jfsd.exam.repository.CustomerRepository;
@Service
public class CustomerServiceImpl implements CustomerService {

	 @Autowired
	    private CustomerRepository customerRepository;

	    @Override
	    public String updateCustomer(Customer customer) {
	        if (customer.getId() == null) {
	            return "give id";
	        }

	        Optional<Customer> existingCustomerOpt = customerRepository.findById(customer.getId());
	        if (existingCustomerOpt.isPresent()) {
	            Customer existingCustomer = existingCustomerOpt.get();
	            existingCustomer.setName(customer.getName());
	            existingCustomer.setAddress(customer.getAddress());
	            customerRepository.save(existingCustomer);
	            return "Customer updated successfully.";
	        } else {
	            return "Customer not found.";
	        }
	    }

	    @Override
	    public String insertCustomer(Customer customer) {
	        customerRepository.save(customer);
	        return "Customer added successfully.";
	    }

}
