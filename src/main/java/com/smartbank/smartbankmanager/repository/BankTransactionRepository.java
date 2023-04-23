package com.smartbank.smartbankmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartbank.smartbankmanager.entities.BankTransactions;


public interface BankTransactionRepository extends JpaRepository<BankTransactions, Integer>{

	

	List<BankTransactions> findByCustidfrom(int id);

}
