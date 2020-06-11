package de.bruxxen.MyGourmet.Model;

public class CreditCard {
	private String name;

	public CreditCard(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return this.name;
	}
}
