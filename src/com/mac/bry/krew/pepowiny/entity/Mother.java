package com.mac.bry.krew.pepowiny.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="mother")
public class Mother {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="surname")
	private String surname;
	
	@Column(name="name")
	private String name;
	
	@Column(name="PESEL")
	private String PESEL;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="mother_adress_id")
	private MotherAdress motherAdress;
	
	@ManyToOne
	@JoinColumn(name="hospital_id", nullable = false)
	private Hospital hospital;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPESEL() {
		return PESEL;
	}

	public void setPESEL(String pESEL) {
		PESEL = pESEL;
	}

	public MotherAdress getMotherAdress() {
		return motherAdress;
	}

	public void setMotherAdress(MotherAdress motherAdress) {
		this.motherAdress = motherAdress;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public Mother(int id, String surname, String name, String pESEL, MotherAdress motherAdress, Hospital hospital) {
		super();
		this.id = id;
		this.surname = surname;
		this.name = name;
		PESEL = pESEL;
		this.motherAdress = motherAdress;
		this.hospital = hospital;
	}

	public Mother(String surname, String name, String pESEL) {
		super();
		this.surname = surname;
		this.name = name;
		PESEL = pESEL;
	}

	public Mother(String surname, String name, String pESEL, MotherAdress motherAdress) {
		super();
		this.surname = surname;
		this.name = name;
		PESEL = pESEL;
		this.motherAdress = motherAdress;
	}

	public Mother() {
		super();
	}
	
	
}
