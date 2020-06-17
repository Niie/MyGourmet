package de.bruxxen.MyGourmet.Converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

public class ReplaceConverter implements Converter {

	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null) {
			return value.replaceAll("\\s+", "_");
		}else {
			return null;
		}
	}
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			return value.toString();
		}else {
			return null;
		}
	}

}
