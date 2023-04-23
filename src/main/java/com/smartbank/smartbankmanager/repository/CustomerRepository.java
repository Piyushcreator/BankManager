package com.smartbank.smartbankmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.smartbank.smartbankmanager.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	

	public Customer getByEmail(String email);
	 
}
