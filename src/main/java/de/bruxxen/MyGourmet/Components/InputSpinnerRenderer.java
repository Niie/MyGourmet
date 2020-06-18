package de.bruxxen.MyGourmet.Components;

import java.io.IOException;
import java.util.Map;

import javax.el.ValueExpression;
import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.render.FacesRenderer;
import javax.faces.render.Renderer;

@ResourceDependencies({
	@ResourceDependency(library = "mygourment", name="inputSpinner.js", target = "head"),
	@ResourceDependency(library = "mygourment", name="component.css.js", target = "head")})
@FacesRenderer(componentFamily = "javax.faces.Input", rendererType="de.bruxxen.MyGourmet.Components.InputSpinner")
public class InputSpinnerRenderer extends Renderer{

	public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
		InputSpinner spinner = (InputSpinner) component;
		String clientId = spinner.getClientId();
		encodeInput(context, spinner, clientId);
		encodeButtons(context, spinner, clientId);
	}
	
	private void encodeButtons(FacesContext context, InputSpinner spinner, String clientId) {
		// TODO Auto-generated method stub
		
	}

	private void encodeInput(FacesContext context, InputSpinner spinner, String clientId) throws IOException{
		ResponseWriter writer = context.getResponseWriter();
		writer.startElement("input", spinner);
		writer.writeAttribute("id", clientId, null);
		writer.writeAttribute("name", clientId,  null);;
		Object value = getValue(context, spinner);
		if(value != null) {
			writer.writeAttribute("value", value.toString(),  null);
		}
		writer.writeAttribute("class", "inputSpinner-input",  null);
		writer.endElement("input");
	}
	
	private Object getValue(FacesContext context, InputSpinner spinner) {
		Object submittedValue = spinner.getSubmittedValue();
		if (submittedValue != null) {
			return submittedValue;
		}
		Object value = spinner.getValue();
		Converter converter = getConverter(context, spinner);
		if(converter != null) {
			return converter.getAsString(context,  spinner,  value);
		}else if (value != null) {
			return value.toString();
		}else {
			return "";
		}
	}
	
	private Converter getConverter(FacesContext context, UIComponent comp) {
		Converter conv = ((UIInput)comp).getConverter();
		if (conv != null) return conv;
		ValueExpression exp = comp.getValueExpression("value");
		if(exp == null) return null;
		Class<?> valueType = exp.getType(context.getELContext());
		if (valueType == null) return null;
		return context.getApplication().createConverter(valueType);
	}
	
	public void decode(FacesContext context, UIComponent component) {
		Map<String, String> params = context.getExternalContext().getRequestParameterMap();
		String clientId = component.getClientId();
		String value = params.get(clientId);
		((UIInput)component).setSubmittedValue(value);
	}
	
	public Object getConvertedValue(FacesContext context, UIComponent component, Object submittedValue) throws ConverterException {
		Converter converter = getConverter(context, component);
		if(converter != null) {
			return converter.getAsObject(context, component, (String) submittedValue);
		}else {
			return submittedValue;
		}
	}
}
