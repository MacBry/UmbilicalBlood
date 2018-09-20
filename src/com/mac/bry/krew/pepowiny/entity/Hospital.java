package com.mac.bry.krew.pepowiny.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="HOSPITAL")
public class Hospital {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="hostpital_name")
	private String hostpitalName;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="HOSPITAL_ADRESS_id")
	private HospitalAdress hospitalAdress;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHostpitalName() {
		return hostpitalName;
	}

	public void setHostpitalName(String hostpitalName) {
		this.hostpitalName = hostpitalName;
	}

	public HospitalAdress getHospitalAdress() {
		return hospitalAdress;
	}

	public void setHospitalAdress(HospitalAdress hospitalAdress) {
		this.hospitalAdress = hospitalAdress;
	}

	public Hospital(String hostpitalName, HospitalAdress hospitalAdress) {
		super();
		this.hostpitalName = hostpitalName;
		this.hospitalAdress = hospitalAdress;
	}

	
	public Hospital(String hostpitalName) {
		super();
		this.hostpitalName = hostpitalName;
	}

	public Hospital() {
		super();
	}
	
	
	
}
