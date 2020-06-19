package de.bruxxen.MyGourmet.JS;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="js")
@SessionScoped
public class JS {
	private String first = "", last = "", name = "";

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
		this.name = this.first + " " + this.last;
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
