package de.bruxxen.MyGourmet.Model;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class CustomerBean {
	@Inject CustomerService customerService;
	
	public CustomerService getCustomerService() {
		return this.customerService;
	}

}
