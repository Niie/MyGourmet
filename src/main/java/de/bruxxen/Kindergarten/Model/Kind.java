package de.bruxxen.Kindergarten.Model;

import java.io.Serializable;
import java.util.Date;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class Kind implements Serializable{
	private static final long serialVersionUID = 111L;
	private String info = "Info über etwas";
	private String vorname = "Test", nachname;
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
