package com.primeStore.musicStore.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class ShippingAddress implements Serializable{

	private static final long serialVersionUID = 7554037784214930881L;
	@Id
	@GeneratedValue
	private int idShippingAddress;
	private String streetName;
	private String aparmentNumber;
	private String city;
	private String state;
	
	private String country;
	private String zipCode;
	@OneToOne
	@JoinColumn(name="idCustomer")
	private Customer customer;
	
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public int getIdShippingAddress() {
		return idShippingAddress;
	}
	public void setIdShippingAddress(int idShippingAddress) {
		this.idShippingAddress = idShippingAddress;
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
	public void setCityState(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setCity(String city) {
		this.city = city;
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
