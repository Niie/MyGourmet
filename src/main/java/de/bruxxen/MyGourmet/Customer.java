package de.bruxxen.MyGourmet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;
import javax.faces.context.*;
import javax.servlet.http.HttpServletResponse;

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
	
	public String export() {
		FacesContext fContext = FacesContext.getCurrentInstance();
		try {
			HttpServletResponse resp = (HttpServletResponse) fContext.getExternalContext().getResponse();
			resp.setContentType("text/plain");
			PrintWriter writer = resp.getWriter();
			
			writer.print("First Name: ");
			writer.print(this.firstName);
			writer.println();
			writer.print("Last Name: ");
			writer.print(this.lastName);
			writer.println();
			if(this.useCreditCard) {
				writer.print("Credit Card Type: ");
				writer.print(this.creditCardType);
				writer.println();
				writer.print("Credit Card Number: ");
				writer.print(this.creditCardNumber);
				writer.println();
			}
			writer.close();
			fContext.responseComplete();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		
	}
}
