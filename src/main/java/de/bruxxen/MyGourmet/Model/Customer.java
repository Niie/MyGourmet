package de.bruxxen.MyGourmet.Model;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.*;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import de.bruxxen.MyGourmet.Interfaces.Annotation.Birthday;


@ManagedBean
@SessionScoped
public class Customer {

	private String firstName, lastName;	
	private boolean male;
	public boolean useCreditCard = false;
	private CreditCard creditCard = new CreditCard("VISA");
	private Date birthday;
	private int zipCode;
	private List<Adress> adresses = new ArrayList<Adress>();
	private Adress currentAdress;
	private String city, street, mail;
	private List<String> preferredCategories = new ArrayList<String>();

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
	public String getMail() {
		return this.mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}	
	public boolean isMale(){
		return this.male;
	}
	public void setMale(boolean male) {
		this.male = male;
	}	
	public boolean getUseCreditCard() {
		return this.useCreditCard;
	}
	public void setUseCreditCard(boolean useCreditCard) {
		this.useCreditCard = useCreditCard;
	}
	public CreditCard getCreditCard() {
		return this.creditCard;
	}
	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
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
	public List<String> getPreferredCategories(){
		return this.preferredCategories;
	}
	public void setPreferredCategories(List<String> preferredCategories) {
		this.preferredCategories = preferredCategories;
	}
	public List<Adress> getAdresses(){
		return this.adresses;
	}
	public void setAdresses(List<Adress> adresses) {
		this.adresses = adresses;
	}	
	public Adress getCurrentAdress() {
		return this.currentAdress;
	}
	public void setCurrentAdress(Adress currentAdress) {
		this.currentAdress = currentAdress;
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
				writer.print(this.creditCard);
				writer.println();
				writer.print("Credit Card Number: ");
				writer.print(this.creditCard.getCardNumber());
				writer.println();
			}
			writer.close();
			fContext.responseComplete();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;		
	}
	
	public String addAdress(Adress adress) {
		this.adresses.add(adress);
		return "/showCustomer.xhtml";
	}
	
	public String editAdress(Adress adress) {
		this.setCurrentAdress(adress);
		return "/editAdress.xhtml";
	}
	
	public void deleteAdress(Adress adress) {
		this.adresses.remove(adress);
	}
	
	public String testCustomer() {
		this.male = true;
		this.firstName = "Andreas";
		this.lastName = "Schumm";
		this.city = "TestCity";
		this.zipCode = 12345;
		this.mail = "testMail@testServer.de";
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 1900);
		cal.set(Calendar.MONTH, 0);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		this.birthday = cal.getTime();
		
		this.preferredCategories = new ArrayList<String>();
		this.preferredCategories.add("DE");
		this.preferredCategories.add("TUR");
		
		this.useCreditCard = true;
		this.creditCard = new CreditCard("Mastercard");
		this.creditCard.setCardNumber(1234);
		
		this.adresses = new ArrayList<Adress>();
		this.adresses.add(new Adress(12345, "LocalCity", "NortStreet 2", "Germany"));
		this.adresses.add(new Adress(65435, "Princesscastle", "Fairytail", "Farfaraway"));
		this.adresses.add(new Adress(12345, "MoonCity", "Behind the earth", "Moon"));
		
		return "/showCustomer.xhtml";
	}
}
