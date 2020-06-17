package de.bruxxen.MyGourmet.Controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class User {
	private String contract = "contract2";
	
	public String getContract() {
		return this.contract;
	}
	public void setContract(String contract) {
		this.contract = contract;
	}

}
