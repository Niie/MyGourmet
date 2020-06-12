package de.bruxxen.MyGourmet.Converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.faces.validator.ValidatorException;

import de.bruxxen.MyGourmet.Messages.LocalMessage;

@FacesConverter("de.bruxxen.MyGourmet.Converter.ZipCodeConverter")
public class ZipCodeConverter implements Converter {

	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		if(value != null) {
			for (int i=0; i < value.length(); i++) {
				if (!Character.isDigit(value.charAt(i))) {
					value = value.substring(0, i) + value.substring(i + 1);
					i--;
				}
			}
		}		
		try {
			int zipCode = Integer.valueOf(value);
			if (zipCode < 99999 && zipCode > 9999) return zipCode;
			else {
				FacesMessage msg = LocalMessage.getFacesMessage(context, FacesMessage.SEVERITY_ERROR, 
						"input_required");
				throw new ValidatorException(msg);
			}
		} catch (Exception e) {
			throw new ConverterException("Zip invalid");
		}		
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		return value.toString();
	}

}
