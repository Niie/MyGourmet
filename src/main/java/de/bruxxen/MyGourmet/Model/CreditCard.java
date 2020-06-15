package de.bruxxen.MyGourmet.Model;

public class CreditCard {
	private String name = "Mastercard";
	private int numberLength = 0;
	private int cardNumber;

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
	public int getCardNumber() {
		return this.cardNumber;
	}
	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
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
		if(this.name.equalsIgnoreCase("Mastercard"))	this.setNumberLength(4);
		else if(this.name.equalsIgnoreCase("VISA"))		this.setNumberLength(5);
		else if(this.name.equalsIgnoreCase("JCB"))		this.setNumberLength(6);
		else											this.setNumberLength(8);

	}
}
