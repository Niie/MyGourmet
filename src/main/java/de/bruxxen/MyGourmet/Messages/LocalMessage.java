package de.bruxxen.MyGourmet.Messages;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class LocalMessage {

	public static FacesMessage getFacesMessage(FacesContext context, FacesMessage.Severity severity, String msgKey, Object...args) {
		
		Locale locale = context.getViewRoot().getLocale();
		ResourceBundle bundle = ResourceBundle.getBundle(context.getApplication().getMessageBundle(), locale);
		String msg = bundle.getString(msgKey);
		if(args != null) {
			MessageFormat format = new MessageFormat(msg);
			msg = format.format(args);
		}
		return new FacesMessage(severity, msg, null);
	}
}
