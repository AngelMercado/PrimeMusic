package com.primeStore.musicStore.domain;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.beans.propertyeditors.CustomMapEditor;

public class BillingAddress implements Serializable{
	private static final long serialVersionUID = 7770908352764424171L;
	
	@Id
	@GeneratedValue
	private int idBillingAddress;
	private String streetName;
	private String aparmentNumber;
	private String cityState;
	private String contry;
	private String zipCode;
	
	@OneToOne
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

	public String getCityState() {
		return cityState;
	}

	public void setCityState(String cityState) {
		this.cityState = cityState;
	}

	public String getContry() {
		return contry;
	}

	public void setContry(String contry) {
		this.contry = contry;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}