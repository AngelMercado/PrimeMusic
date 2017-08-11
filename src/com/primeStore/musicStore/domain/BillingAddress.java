package com.primeStore.musicStore.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.beans.propertyeditors.CustomMapEditor;

@Entity
public class BillingAddress implements Serializable{
	private static final long serialVersionUID = 7770908352764424171L;
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Id
	@GeneratedValue
	private int idBillingAddress;
	private String streetName;
	private String aparmentNumber;
	private String city;
	private String state;
	private String country;
	private String zipCode;
	@OneToOne
	@JoinColumn(name="idCustomer")
	private Customer customer;
	
	public int getIdBillingAddress() {
		return idBillingAddress;
	}
	public void setIdBillingAddress(int idBillingAddress) {
		this.idBillingAddress = idBillingAddress;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getAparmentNumber() {
		return aparmentNumber;
	}
	public void setAparmentNumber(String aparmentNumber) {
		this.aparmentNumber = aparmentNumber;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
