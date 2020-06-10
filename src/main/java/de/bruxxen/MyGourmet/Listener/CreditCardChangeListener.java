package de.bruxxen.MyGourmet.Listener;

import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;

import com.sun.faces.el.ELContextImpl;

import de.bruxxen.MyGourmet.Customer;

public class CreditCardChangeListener implements ValueChangeListener {

	public void processValueChange(ValueChangeEvent event) throws AbortProcessingException {
		Boolean useCreditCard = (Boolean) event.getNewValue();
		FacesContext fcontext = FacesContext.getCurrentInstance();
		if(useCreditCard != null) {
			//ELContext elcontext = fcontext.getELContext();
			//Customer customer = (Customer) elcontext.ge
		}
		
	}
	
	

}

