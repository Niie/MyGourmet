package de.bruxxen.MyGourmet.Provider;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.convert.Converter;

import de.bruxxen.MyGourmet.Converter.ReplaceConverter;

@ManagedBean
@ApplicationScoped
public class ConverterProvider {
	
	public Converter getReplaceConverter() {
		return new ReplaceConverter();
	}

}
