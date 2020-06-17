package de.bruxxen.MyGourmet.Controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class User {
	private String contract = "/otherContract";
	private boolean altContract;
	
	public boolean getAltContract() {
		return this.altContract;
	}
	public void setAltContract(boolean altContract) {
		this.altContract = altContract;
	}
	
	public String getDirect(String site) {
		if (this.altContract) return this.contract + site;
		else return site;
	}
	
	public String getContract() {
		return this.contract;
	}
	
	public String switchContract() {
		this.altContract = !this.altContract;
		return null;
	}
	public void setContract(String contract) {
		this.contract = contract;
	}

}
