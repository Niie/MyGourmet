package de.bruxxen.MyGourmet;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;
import javax.faces.context.*;

@ManagedBean
@SessionScoped
public class Customer {
	private String firstName ="";
	private String lastName = "";
	private boolean useCreditCard = false;
	private String creditCardType = "VISA";
	private int creditCardNumber;
	
	public String getFirstName() {
		return this.firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return this.lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}	
	public boolean getUseCreditCard() {
		return this.useCreditCard;
	}
	public void setUseCreditCard(boolean useCreditCard) {
		this.useCreditCard = useCreditCard;
	}
	public String getCreditCardType() {
		return this.creditCardType;
	}
	public void setCreditCardType(String creditCardType) {
		this.creditCardType = creditCardType;
	}
	public int getCreditCardNumber() {
		return this.creditCardNumber;
	}
	public void setCreditCardNumber(int creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
	
	public void useCreditCardChanged(ValueChangeEvent e) {
		this.useCreditCard =! this.useCreditCard;
		FacesContext.getCurrentInstance().renderResponse();
	}
}
