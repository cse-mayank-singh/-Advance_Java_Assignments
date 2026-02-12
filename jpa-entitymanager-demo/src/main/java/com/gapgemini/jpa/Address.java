package com.gapgemini.jpa;
import jakarta.persistence.Embeddable;
@Embeddable
public class Address {
	private String city;
	private String state;
	private String branch;
	public Address(String city, String state, String branch) {
		super();
		this.city = city;
		this.state = state;
		this.branch = branch;
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
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
}
