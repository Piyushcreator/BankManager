package com.smartbank.smartbankmanager.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CUSTOMER")
public class Customer {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private int id;
	private String name;
	@Column(unique = true)
	private String email;
	private String password;
	private String bankname;
	private int savingaccbalance;
	private int currentaccbalance;
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getBankname() {
		return bankname;
	}
	public void setBankname(String bankname) {
		this.bankname = bankname;
	}
	public int getSavingaccbalance() {
		return savingaccbalance;
	}
	public void setSavingaccbalance(int savingaccbalance) {
		this.savingaccbalance = savingaccbalance;
	}
	public int getCurrentaccbalance() {
		return currentaccbalance;
	}
	public void setCurrentaccbalance(int currentaccbalance) {
		this.currentaccbalance = currentaccbalance;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", bankname="
				+ bankname + ", savingaccbalance=" + savingaccbalance + ", currentaccbalance=" + currentaccbalance
				+ "]";
	}

	
	
}
