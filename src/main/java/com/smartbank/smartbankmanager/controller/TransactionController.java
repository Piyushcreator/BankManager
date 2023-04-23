package com.smartbank.smartbankmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartbank.smartbankmanager.entities.BankTransactions;
import com.smartbank.smartbankmanager.services.BankTransactionService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class TransactionController {

	@Autowired
	private BankTransactionService bts;
	
	@GetMapping("api/transaction")
	public List<BankTransactions> getAll(){
		return bts.getAll();		
	}
}
