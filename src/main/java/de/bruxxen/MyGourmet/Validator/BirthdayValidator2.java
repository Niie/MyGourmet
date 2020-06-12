package de.bruxxen.MyGourmet.Validator;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@ManagedBean
@RequestScoped
@FacesValidator(value=BirthdayValidator2.VALIDATOR_ID)
public class BirthdayValidator2 implements Validator, Serializable {
	private static final long serialVersionUID = 1L;
	public static final String VALIDATOR_ID = "de.bruxxen.MyGourmet.Validator.BirthdayValidator2";

	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		Date date = (Date) value;
		if(date.after(new Date())) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Birthday is in the future.", null);
			throw new ValidatorException(msg);
		}else {
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.YEAR, 1900);
			cal.set(Calendar.MONTH, 0);
			cal.set(Calendar.DAY_OF_MONTH, 1);
			
			if(date.before(cal.getTime())) {
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Birthday is before Jan 1, 1900.", null);
				throw new ValidatorException(msg);
			}
			
		}
		
		
	}
	

}
