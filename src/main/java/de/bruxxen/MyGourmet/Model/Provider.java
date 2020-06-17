package de.bruxxen.MyGourmet.Model;

public class Provider {
	private String name;
	private int id;
	private String providerInfo;
	
	public Provider(String name, int id, String providerInfo) {
		this.name = name;
		this.id = id;
		this.providerInfo = providerInfo;
	}

	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getInfo() {
		return this.providerInfo;
	}
	public void setInfo(String providerInfo) {
		this.providerInfo = providerInfo;
	}
	
}
