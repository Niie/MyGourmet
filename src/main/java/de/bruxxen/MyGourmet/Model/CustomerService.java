package de.bruxxen.MyGourmet.Model;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

@ApplicationScoped
public class CustomerService {
	private String test = "Test";
	
	public String getTest() {
		return this.test;
	}
	public void setTest(String test) {
		this.test = test;
	}
	@Produces @Named
	public int calcRandom() {
		return 10;
	}

}
