package com.smartbank.smartbankmanager.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TRANSACTIONS")
public class BankTransactions {

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private int id;
	private int custidfrom;
	private int custidTo;
	
	public BankTransactions() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCustidfrom() {
		return custidfrom;
	}
	public void setCustidfrom(int custidfrom) {
		this.custidfrom = custidfrom;
	}
	public int getCustidTo() {
		return custidTo;
	}
	public void setCustidTo(int custidTo) {
		this.custidTo = custidTo;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	private int amount;
}
