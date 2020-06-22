package de.bruxxen.MyGourmet.Model;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CustomerService {
	private String test = "Test";
	
	public String getTest() {
		return this.test;
	}
	public void setTest(String test) {
		this.test = test;
	}

}
