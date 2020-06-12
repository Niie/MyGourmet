package de.bruxxen.MyGourmet.Validator;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import org.jboss.logging.Message;

import de.bruxxen.MyGourmet.Model.CreditCard;

@ManagedBean
@RequestScoped
@FacesValidator("de.bruxxen.MyGourmet.Validator.CreditCardValidator")
public class CreditCardValidator implements Validator, Serializable {
	private static final long serialVersionUID = 1L;
	public static final String VALIDATOR_ID = "de.bruxxen.MyGourmet.Validator.CreditCardValidator";
	private String chosenCC = "";
	

	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		CreditCard currentCC = new CreditCard(chosenCC);
		
		if(currentCC != null) {
			String ccNumber = String.valueOf(value);
			if (ccNumber.length() != currentCC.getNumberLength()) {
				Locale locale = context.getViewRoot().getLocale();
				ResourceBundle bundle = ResourceBundle.getBundle("de.bruxxen.MyGourmet.Messages.messages");
				String msgString = MessageFormat.format(bundle.getString("validateCreditCardNumber.NUMBER"), currentCC.getNumberLength());
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, msgString, null);				
				throw new ValidatorException(msg);
			}
		}
	}	
	public void postValidateCCType(ComponentSystemEvent event) {
		UIInput input = (UIInput) event.getComponent();
		this.chosenCC = (String) input.getValue();
	}
}
