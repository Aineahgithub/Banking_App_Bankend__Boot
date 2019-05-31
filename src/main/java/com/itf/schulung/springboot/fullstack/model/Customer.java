package com.itf.schulung.springboot.fullstack.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.itf.schulung.springboot.fullstack.Validator.EmailConstraint;
import com.itf.schulung.springboot.fullstack.Validator.NamesConstraint;
import com.itf.schulung.springboot.fullstack.Validator.PhoneContraint;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NamesConstraint
	private String firstName;
	@NamesConstraint
	private String lastName;
	@OneToOne
	private Login login;
	@EmailConstraint
	private String email;
	@PhoneContraint
	private String telephone;
	@OneToMany(cascade = CascadeType.PERSIST)
	private List<Account> accounts;
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;

	public Customer() {
	}

	public Customer(String firstName, String lastName, int age, String telephone, String email, Address address,
			Login login) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.telephone = telephone;
		this.email = email;
		this.address = address;
		this.login = login;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	private Integer age;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAge() {
		return age;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
