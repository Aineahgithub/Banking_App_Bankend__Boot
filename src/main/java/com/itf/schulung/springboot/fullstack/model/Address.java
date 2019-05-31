package com.itf.schulung.springboot.fullstack.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Value;

import com.itf.schulung.springboot.fullstack.Validator.NamesConstraint;
import com.itf.schulung.springboot.fullstack.Validator.StreetContraint;

@Entity
   public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NamesConstraint
	private String city;
	private String zipCode;
	@NamesConstraint
	String country;
	@NamesConstraint
	private String street;

	public Address() {
	}

	public Address(int id, String street, String city, String zipCode, String country) {
		this.id = id;
		this.street = street;
		this.city = city;
		this.zipCode = zipCode;
		this.country = country;

	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

}
