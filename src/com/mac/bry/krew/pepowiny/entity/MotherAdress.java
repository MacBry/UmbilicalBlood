package com.mac.bry.krew.pepowiny.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mother_adress")
public class MotherAdress {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="")
	private int id;
	
	@Column(name="city")
	private String city;
	
	@Column(name="zip_code")
	private String zipCode;
	
	@Column(name="prefix")
	private String prefix;
	
	@Column(name="street")
	private String street;
	
	@Column(name="house_number")
	private String houseNumber;
	
	@Column(name="local_number")
	private String localNumber;

	public int getId() {
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

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getLocalNumber() {
		return localNumber;
	}

	public void setLocalNumber(String localNumber) {
		this.localNumber = localNumber;
	}

	public MotherAdress(int id, String city, String zipCode, String prefix, String street, String houseNumber,
			String localNumber) {
		super();
		this.id = id;
		this.city = city;
		this.zipCode = zipCode;
		this.prefix = prefix;
		this.street = street;
		this.houseNumber = houseNumber;
		this.localNumber = localNumber;
	}
	

	public MotherAdress(String city, String zipCode, String prefix, String street, String houseNumber,
			String localNumber) {
		super();
		this.city = city;
		this.zipCode = zipCode;
		this.prefix = prefix;
		this.street = street;
		this.houseNumber = houseNumber;
		this.localNumber = localNumber;
	}

	public MotherAdress() {
		super();
	}
	
	
	
}
