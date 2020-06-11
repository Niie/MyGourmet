package de.bruxxen.MyGourmet.Model;

public class CreditCard {
	private String name;
	private int numberLength = 0;

	public CreditCard(String name) {
		this.name = name;
		this.setNumberLengthByCCName();
	}
	
	public String getName() {
		return this.name;
	}
	public void setName(String name){
		this.name = name;
		this.setNumberLengthByCCName();
	}
	public int getNumberLength() {
		return this.numberLength;
	}
	public void setNumberLength(int numberLength) {
		this.numberLength = numberLength;
	}
	public String toString() {
		return this.name;
	}
	private void setNumberLengthByCCName() {
		switch(this.name) {
		case "Mastercard":
			this.numberLength = 5;
			break;
		case "VISA":
			this.numberLength = 6;
			break;
		case "JCB":
			this.numberLength = 8;
			break;	
		default:
			break;

		}
	}
}
