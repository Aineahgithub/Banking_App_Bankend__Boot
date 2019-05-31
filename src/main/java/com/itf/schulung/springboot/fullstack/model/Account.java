package com.itf.schulung.springboot.fullstack.model;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.itf.schulung.springboot.fullstack.Validator.NamesConstraint;
import com.itf.schulung.springboot.fullstack.model.Customer;

@Entity
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@JsonFormat(pattern = "dd.MM.yyyy")
	private Date date = new Date();

	@Positive
	private double balance;
	private long customer_id;
	@OneToMany(cascade = CascadeType.ALL)
	private List<MoneyTransferForm> transactions;
	private String accountNr;
	@NamesConstraint
	private String type;

	static DecimalFormat mk = new DecimalFormat("0.00");

	public Account(String balance, String Accountnr, String string, double d) {
		this.balance = AccountFactory.getRandomBalance();
	}

	public Account(int id, double balance, long customer_id) {

		this.id = id;
		this.balance = balance;
		this.customer_id = customer_id;
	}

	public Account(double randomBalance, String randomAccountnr, String randomWithdraw, double randomDeposit) {
	}

	public Account() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<MoneyTransferForm> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<MoneyTransferForm> transactions) {
		this.transactions = transactions;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public long getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(long customer_id) {
		this.customer_id = customer_id;
	}

	public String getAccountNr() {
		if (accountNr == null)
			accountNr = AccountFactory.getRandomAccountnr();

		return accountNr;
	}

	public void setAccountNr(String accountNr) {
		this.accountNr = accountNr;
	}

	public String getWithdraw() throws Throwable {
		return AccountFactory.getRandomWithdraw();
	}

	public double getDeposit() {
		return AccountFactory.getRandomDeposit();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
