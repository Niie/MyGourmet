package de.bruxxen.MyGourmet.Model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

@ManagedBean
public class Adress {
	private int zipCode;
	private String city, street, country;
	
	public int getZipCode() {
		return this.zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	public String getCity() {
		return this.city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return this.street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCountry() {
		return this.country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String edit(Adress adress) {
		return "/editAdress.xhtml";
	}

}
