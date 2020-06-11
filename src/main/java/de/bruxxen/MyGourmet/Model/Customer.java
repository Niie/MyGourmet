package de.bruxxen.MyGourmet.Model;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.*;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import de.bruxxen.MyGourmet.Interfaces.Annotation.Birthday;


@ManagedBean
@SessionScoped
public class Customer {

	@NotNull(message = "Name cannot be null")
	private String firstName, lastName;	
	public boolean useCreditCard = false;
	private String creditCardType = "VISA";
	private int creditCardNumber;
	@Birthday	
	private Date birthday;
	@Max(value=100)
	private int zipCode;
	private String city, street;

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
	public Date getBirthday() {
		return this.birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
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
