package com.primeStore.musicStore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Authorities {
	@Id
	@GeneratedValue
	private int idAuthorities;
	private String username;
	private String Authority;
	
	public int getIdAuthorities() {
		return idAuthorities;
	}
	public void setIdAuthorities(int idAuthorities) {
		this.idAuthorities = idAuthorities;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAuthority() {
		return Authority;
	}
	public void setAuthority(String authority) {
		Authority = authority;
	}
}
