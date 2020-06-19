package de.bruxxen.Kindergarten.Model;

import java.util.Date;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Kind {
	private String vorname = "Test", nachname, info;
	private Date geburtstag;
	private int gruppe;

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public String getVorname() {
		return this.vorname;
	}
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	public String getNachname() {
		return this.nachname;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getInfo() {
		return this.info;
	}
	
}
