package de.bruxxen.MyGourmet.Messages;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.Location;

@ManagedBean
public class LocalMessage {

	public static FacesMessage getFacesMessage(FacesContext context, FacesMessage.Severity severity, String msgKey, Object...args) {
		
		Locale locale = context.getViewRoot().getLocale();
		ResourceBundle bundle = ResourceBundle.getBundle("de.bruxxen.MyGourmet.Messages.messages", locale);
		String msg = bundle.getString(msgKey);
		if(args != null) {
			MessageFormat format = new MessageFormat(msg);
			msg = format.format(args);
		}
		return new FacesMessage(severity, msg, null);
	}
	
	public static void changeLocal() {
		String newLocale = getOppositeLocale();
		FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale(newLocale));
	}
	
	public static String getCurrentLocale() {
		return FacesContext.getCurrentInstance().getViewRoot().getLocale().toString();
	}
	public static String getOppositeLocale() {
		String current = getCurrentLocale();
		if (current.equalsIgnoreCase("de"))return "en";
		else return "de";
	}
}
