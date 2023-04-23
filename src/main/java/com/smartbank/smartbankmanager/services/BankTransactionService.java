package com.smartbank.smartbankmanager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartbank.smartbankmanager.entities.BankTransactions;
import com.smartbank.smartbankmanager.repository.BankTransactionRepository;

@Service
public class BankTransactionService {

	@Autowired
	private BankTransactionRepository btr;
	
	public List<BankTransactions> getAll() {
		
		return btr.findAll();
	}
	public List<BankTransactions> getAllforCustomer(int id) {
		
		return btr.findByCustidfrom(id);
	}
	
	public BankTransactions addTransaction(BankTransactions bt) {
		 return btr.save(bt);
	}
	
	public BankTransactions updateTransaction(BankTransactions bt) {
		 return btr.save(bt);
	}
	
	
	public void deleteTransaction(int id)	{
		btr.deleteById(id);

	}
}
