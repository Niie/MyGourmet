package de.bruxxen.MyGourmet.Validator;

import java.io.Serializable;

import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import de.bruxxen.MyGourmet.Model.CreditCard;

@FacesValidator(value=CreditCardValidator.VALIDATOR_ID)
public class CreditCardValidator implements Validator, Serializable {
	private static final long serialVersionUID = 1L;
	public static final String VALIDATOR_ID = "de.bruxxen.MyGourmet.Validator.CreditCardValidator";
	private UIInput chosenCC;
	

	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		CreditCard currentCC = new CreditCard(chosenCC.getValue().toString());
		
	}
	
	public void postValidateCCType(ComponentSystemEvent event) {
		this.chosenCC = (UIInput)event.getComponent();
		
	}

}
