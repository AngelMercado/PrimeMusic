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
	private String cityState;
	
	private String contry;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	

}
