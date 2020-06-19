package de.bruxxen.MyGourmet.JS;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;

@ManagedBean(name="js")
@SessionScoped
public class JS {
	private String first = "", last = "", name = "", country, staate;
	private String[] countries = {"Deutschland", "Schweiz", "Österreich"};
	private ArrayList<String> staates = new ArrayList<String>();

	public String getFirst() {
		return this.first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getLast() {
		return this.last;
	}
	public void setLast(String last) {
		this.last = last;
	}
	public String getName() {
		this.name = this.first + " " + this.last + " " + this.country;
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return this.country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getStaate() {
		return this.staate;
	}
	public void setStaate(String staate) {
		this.staate = staate;
	}
	public String[] getCountries() {
		return this.countries;
	}
	public void setCountries(String[] countries) {
		this.countries = countries;
	}
	public ArrayList<String> getStaates() {
		return this.getSpecificStaateList(this.country);
	}
	public void setStaates(ArrayList<String> staates) {
		this.staates = staates;
	}
	private ArrayList<String> getSpecificStaateList(String country) {
		ArrayList<String> toReturn = new ArrayList<String>();
		for (int i = 0; i < 10; i++) {
			toReturn.add(country + " " + i);
		}
		return toReturn;
	}
	public void changeCountry(ValueChangeEvent ev) {
		this.staate = null;
		
	}
	private void updateStateItems(String country) {
		if (country != null) {
			this.setStaates(staates);
		}
	}
}
