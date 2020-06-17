package de.bruxxen.MyGourmet.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import de.bruxxen.MyGourmet.Model.Provider;

@ManagedBean
@SessionScoped
public class Providers {
	private ArrayList<Provider> providers = new ArrayList<Provider>();
	private int id;
	private int currentProviderPosition;
	
	public Providers() {
		this.init();
	}

	private void init() {
		this.testProvider();
	}
	
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public ArrayList<Provider> getProviders(){
		return this.providers;
	}
	public void setProviders(ArrayList<Provider> providers) {
		this.providers = providers;
	}
	
	public boolean checkId(int id) {
		for (int i = 0; i < this.providers.size(); i++) {
			if (this.providers.get(i).getId() == id) {
				this.currentProviderPosition = i;
				return true;
			}
		}
		return false;
	}
	public String getInfo() {
		return this.providers.get(this.currentProviderPosition).getInfo();
	}
	
	private void testProvider() {
		this.providers.add(new Provider("Asia Imbiss", 123, "Gebratener Reis gebratenes Eis alles gebraten!"));
		this.providers.add(new Provider("Gertruds Döner", 221, "Spezial Döner mit Schnitzel!"));
		this.providers.add(new Provider("Pizza Connection", 675, "Pizzakrationen die jede Vorstellung übersteigen!"));
		this.providers.add(new Provider("TacoLibre", 971, "Der Treffpunkt für jede Gang die etwas auf sich hält!"));
		this.providers.add(new Provider("France ala Brace", 231, "Das teuerste Essen von ganz Aquacity"));
		this.providers.add(new Provider("Kalinka Topf", 564, "Borscht?"));
	}
}
