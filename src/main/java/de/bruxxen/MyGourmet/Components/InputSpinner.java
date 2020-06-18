package de.bruxxen.MyGourmet.Components;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIInput;

@FacesComponent("de.bruxxen.MyGourmet.Components.InputSpinner")
public class InputSpinner extends UIInput {
	public static final String COMPONENT_TYPE = "de.bruxxen.comp.InputSpinner";
	enum PropertyKeys {inc}
	
	public InputSpinner() {
		setRendererType("de.bruxxen.comp.InputSpinner");
	}
	public int getInc() {
		return (Integer)getStateHelper().eval(PropertyKeys.inc, 1);
	}
	public void setInc(int inc) {
		getStateHelper().put(PropertyKeys.inc,  inc);
	}

}
