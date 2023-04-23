package com.smartbank.smartbankmanager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartbank.smartbankmanager.entities.Customer;
import com.smartbank.smartbankmanager.repository.CustomerRepository;


@Service
public class CustomerService {

	@Autowired
	private CustomerRepository cr;
	
	public List<Customer> getAllCustomers() {
		
		return cr.findAll();
		
	}
	
	public Customer getCustomerByEmail(String email) {
		return cr.getByEmail(email);
		
	}
	@SuppressWarnings("deprecation")
	public Customer getById(int id) {
		return cr.getById(id);
		
	}
	
	public Customer addCustomer(Customer cus) {
		 return cr.save(cus);
	}
	
	public Customer updateCustomer(Customer cus) {
		 return cr.save(cus);
	}
	
	
	public void deleteCustomer(int id)	{
		cr.deleteById(id);

	}
	
}
