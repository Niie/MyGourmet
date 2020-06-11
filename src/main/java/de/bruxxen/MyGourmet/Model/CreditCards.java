package de.bruxxen.MyGourmet.Model;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class CreditCards {
	public ArrayList<CreditCard> possibleCardTypes = new ArrayList<CreditCard>();

	public CreditCards() {
		this.init();	
	}	
	private void init() {
		this.possibleCardTypes.add(new CreditCard("Mastercard"));
		this.possibleCardTypes.add(new CreditCard("VISA"));
		this.possibleCardTypes.add(new CreditCard("JCB"));
	}
	public ArrayList getPossibleCardTypes(){
		return this.possibleCardTypes;
	}
}
