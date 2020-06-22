package de.bruxxen.MyGourmet.Model;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;





@Named
@SessionScoped
public class WizardBean implements Serializable {
	private int testNumber = 0;
	
	public int getTestNumber() {
		return this.testNumber;
	}
	
	@Produces @Named
	public void increaseTestNumber() {
		this.testNumber++;
	}
}
